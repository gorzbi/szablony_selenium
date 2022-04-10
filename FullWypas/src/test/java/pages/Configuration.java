package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Configuration {

    public class BrowserManager {

        @Test
        public static void Manager() {
            WebDriverManager.firefoxdriver().setup();
            WebDriver firefox = new FirefoxDriver();
            firefox.manage().window().maximize();
            firefox.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            firefox.get("https://google.com");

            //komentarz
        }
    }
}
