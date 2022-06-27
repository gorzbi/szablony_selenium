package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class RaportScreen {

    // framework dla raportu
    @Test

    public void raport() throws IOException {

        // deklarowanie zmiennej i pamięci dla raportu
        ExtentReports extent = new ExtentReports();

        // deklarowanie raportu i gdzie raport ma się zapisać
        ExtentSparkReporter spark = new ExtentSparkReporter("C:/Users/zbigniew.gornowicz/Desktop/raporciktest.html");

        // konfiguracja raportu
        spark.config().setTheme(Theme.DARK);
        spark.config().setReportName("Nazwa raportu");
        spark.config().setDocumentTitle("Nazwa dokumentu");

        // wypełnianie raportu
        extent.attachReporter(spark);


        // ----------------------TEST CASE 01

        ExtentTest test01 = extent.createTest("Przypadek 01");

        // pierwszy krok w raporcie, np. info
        test01.info("Info, że zaczynam test");

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefox = new FirefoxDriver();

        firefox.get("https://www.google.com/");

        // drugi krok w raporcie
        test01.pass("Uruchomiłem Google");

        if (firefox.findElement(By.id("CXQnmb")).isDisplayed())
        // trzeci krok w raporcie
        {
            test01.pass("Pojawił się pop-up");
            test01.pass("Robię screen przed akceptacją polityki", getScreenschot(firefox)); // wywołanie metody pobierającej screen

            firefox.findElement(By.id("L2AGLb")).click();
            test01.pass("Robię screen po akceptacji polityki", getScreenschot(firefox));

            // czwarty krok w raporcie
            test01.pass("Kliknąłem zgodę");
        } else {
            test01.fail("Pop-up się nie pojawił");
            firefox.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("juvepoland");
            firefox.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).click();
        }


        // piąty krok w raporcie
        test01.info("Info, że koniec testu");

        // "wyplucie" raportu
        extent.flush();

    }


    // metody do robienia screena i zapisu
    @Test

    private static String zrzutEkranu(WebDriver firefox) throws IOException {

        // nadanie nazwy dla screena
        int randomNumber = (int) (Math.random() * 1000);

        // zrobienie screena
        TakesScreenshot screenNazwa = (TakesScreenshot) firefox;
        File plik = screenNazwa.getScreenshotAs(OutputType.FILE);
        String sciezkaScreena = "C:/Users/zbigniew.gornowicz/Desktop/"+randomNumber+".png";
        FileUtils.copyFile(plik, new File(sciezkaScreena));
        return sciezkaScreena;
    }

    // pobranie screena
    @Test
    public static Media getScreenschot(WebDriver firefox) throws IOException {

        String sciezkaScreena = zrzutEkranu(firefox);
        return  MediaEntityBuilder.createScreenCaptureFromPath(sciezkaScreena).build();
    }

}
