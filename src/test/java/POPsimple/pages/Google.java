package POPsimple.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Google {

    // identyfikacja elementów na danej stronie i przypisanie ich do zmiennych

    @FindBy(id = "L2AGLb")
    private WebElement zgoda;

    @FindBy(name = "q")
    private WebElement searchInput;

    // przycisk szukaj przed wpisaniem fraz do szukania
    @FindBy(name = "btnK")
    private WebElement search;

    // przycisk szukaj po wpisaniu fraz do szukania
    @FindBy(xpath = "(//input[@name='btnK'])[1]")
    private WebElement search2;



    private WebDriver firefox;

    // zainicjowanie zidentyfikowanych elementów na stronie
    public Google(WebDriver firefox) { //nazwa taka sama jak klasy w której jest
        PageFactory.initElements(firefox, this);
        this.firefox = firefox;
    }


    // ustawianie metod, które mają realizować jakieś zachowania na tej stronie

    public void wyszukanieSlowa(String slowo) { // dajemy parametr o nazwie slowo, który jest zmienną, która będzie różna w różnych testach
        zgoda.click();
        searchInput.click();
        searchInput.sendKeys(slowo); // zmienna slowo zmieniana w testach
        //searchInput.sendKeys(Keys.ENTER);
        search2.click();
    }
}
