package ProsteSzablony;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Firefox {

    @Test

    public void firefox() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefox = new FirefoxDriver();
        firefox.manage().window().maximize();

        firefox.get("https://www.google.com/");

    }

}
