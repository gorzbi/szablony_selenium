package POPsimple.tests;

import POPsimple.pages.Google;
import org.testng.annotations.Test;

public class Leba extends Configuration{

    @Test
    public void testPierwszy() {

        Google wyszukiwanie = new Google(firefox); // stworzenie obiektu na podstawie klasy, której ma dotyczyć test (odwołanie do klasy z pages o nazwie Google) z parametrem z konfiguracji

        wyszukiwanie.wyszukanieSlowa("Leba"); // odwołanie się do metody wyszukującej slowo i podanie parametru

    }
}
