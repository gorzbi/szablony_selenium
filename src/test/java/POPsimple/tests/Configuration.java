package POPsimple.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;
import java.time.Duration;

public class Configuration {

    protected WebDriver firefox; // stworzenie pola wykorzystywanego w innych metodach w innych klasach

    @BeforeMethod
    public void start() {
        WebDriverManager.firefoxdriver().setup();
        firefox = new FirefoxDriver();
        firefox.manage().window().maximize();
        firefox.get("https://www.google.com/");

        System.out.println("Start testu");

        firefox.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //firefox.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void end() {
        System.out.println("Koniec testu");

    }

}
