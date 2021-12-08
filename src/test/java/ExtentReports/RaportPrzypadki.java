package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class RaportPrzypadki {

    // framework dla raportu
    @Test

    public void raport() {

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
            firefox.findElement(By.id("L2AGLb")).click();
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


        // ----------------------TEST CASE 02

        ExtentTest test02 = extent.createTest("Przypadek 02");
        test02.info("Info, że zaczynam test");

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefox2 = new FirefoxDriver();

        firefox2.get("https://www.juvepoland.com/");
        test02.fail("Uruchomiłem Juve");

        extent.flush();
    }

}
