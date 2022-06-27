package POPexcel.tests;

import POPexcel.tools.ReadExcelWithData;
import POPsimple.pages.Google;
import POPsimple.tests.Configuration;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestPierwszy extends Configuration {

    @Test(dataProvider = "data")
    public void testPierwszyWithDataProvider(String fraza) {

        Google wyszukiwanie = new Google(firefox); // stworzenie obiektu na podstawie klasy, której ma dotyczy test z parametrem z konfiguracji

        wyszukiwanie.wyszukanieSlowa(fraza); // odwołanie się do metody wyszukującej slowo i podanie parametru
    }

    // wywołujemy metodę tworzącą obiekt, która korzysta z klasy czytającej excela
    @DataProvider
    public Object[][] data() throws IOException {
        return ReadExcelWithData.readExcel(); // odwołujemy się do metody z tej klasy odpowiedzialnej za czytanie excela
    }
}
