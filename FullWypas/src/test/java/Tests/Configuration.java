package Tests;

import Tools.DriverFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.time.Duration;


public class Configuration {

    protected WebDriver browser; // tworzymy zmienną dla przeglądarki, która będzie używana w innych klasach
    protected static ExtentReports raport; // tworzymy zmienną dla raportu, która będzie używana w innych klasach
    protected static ExtentSparkReporter spark; // // tworzymy zmienną dla konfiguracji raportu


    @BeforeSuite
    public void extentRaport() {
        raport = new ExtentReports(); // tworzymy obiekt

        // konfiguracja raportu
        spark = new ExtentSparkReporter("src/raporty/raport.html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setReportName("Nazwa raportu");
        spark.config().setDocumentTitle("Nazwa dokumentu");
        raport.attachReporter(spark);
    }

    @AfterSuite
        public void wyplujRaport() {
            raport.flush();
        }


    @BeforeMethod
     public void Manager() {

        // ustawianie konfiguracji

        browser = DriverFactory.getDriver("chrome");
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        browser.get("https://google.com");
        //browser.findElement(By.id("L2AGLb")).click(); // zaznaczenie zgody google
    }
}
