package POPsimple.pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;
import java.security.KeyStore;

public class Google {

    // identyfikacja elementów na danej stronie i przypisanie ich do zmiennych

    @FindBy(id = "L2AGLb")
    private WebElement zgoda;

    @FindBy(name = "q")
    private WebElement searchInput;

    @FindBy(name = "btnK")
    private WebElement search;


    private WebDriver firefox;

    // zainicjowanie parametrów
    public Google(WebDriver firefox) {
        PageFactory.initElements(firefox, this);
        this.firefox = firefox;
    }


    // ustawianie metod, które mają realizować jakieś zachowania na tej stronie

    public void wyszukanieSlowa(String slowo) { // dajemy parametr o nazwie slowo, który jest zmienną, która będzie różna w różnych testach
        zgoda.click();
        searchInput.click();
        searchInput.sendKeys(slowo); // zmienna slowo zmieniana w testach
        searchInput.sendKeys(Keys.ENTER);
    }
}