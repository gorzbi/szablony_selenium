package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Google {

    // identyfikacja elementów na danej stronie i przypisanie ich do zmiennych

    @FindBy(id = "L2AGLb")
    private WebElement zgoda;

    @FindBy(name = "q")
    private WebElement poleSzukania;

    // przycisk szukaj przed wpisaniem fraz do szukania
    @FindBy(name = "btnK")
    private WebElement szukajGoogle;

    // przycisk szukaj po wpisaniu fraz do szukania
    @FindBy(xpath = "(//input[@name='btnK'])[1]")
    private WebElement search2;

    private WebDriver browser;

    public Google(WebDriver browser) {
        PageFactory.initElements(browser,this);
        this.browser = browser;
    }


    public void wyszukanieSlowa(String slowo) { // dajemy parametr o nazwie slowo, który jest zmienną, która będzie różna w różnych testach

        zgoda.click();
        poleSzukania.click();
        poleSzukania.sendKeys(slowo); // zmienna slowo zmieniana w klasie testu jako parametr
        szukajGoogle.click();
    }
}
