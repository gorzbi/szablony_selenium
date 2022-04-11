package Tests;

import Pages.Google;
import Tools.Screen;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.ScreenCapture;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

import static Tools.Screen.getScreenschot;

public class SzukajJuveTest extends Configuration {

    @Test
    public void szukamyJuve() throws IOException {

        ExtentTest test01 = raport.createTest("Raport test Juve");

        test01.info("Rozpoczęcie testu");

        Google wyszukaj = new Google(browser); // stworzenie obiektu na podstawie klasy, której ma dotyczyć test (odwołanie do klasy z pages o nazwie Google) z parametrem z konfiguracji
        wyszukaj.wyszukanieSlowa("Juventus"); // odwołanie się do metody wyszukującej slowo i podanie parametru

        WebElement rezultatSzukania = browser.findElement(By.id("result-stats"));

        if (rezultatSzukania.isDisplayed()) {
            test01.pass("Udało się wyszukać", Screen.getScreenschot(browser));// odwołanie do metody z klasy Screen
        }
        else {
            test01.fail("Nie udało się wyszukać", Screen.getScreenschot(browser));
        }
    }
}
