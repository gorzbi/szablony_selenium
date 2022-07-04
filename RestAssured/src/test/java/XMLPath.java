import io.restassured.path.xml.element.Node;
import org.testng.annotations.Test;
import io.restassured.path.xml.XmlPath;

import java.util.List;

public class XMLPath {

    @Test
    public void xmlPathTest(){

        String xml ="<filmy>\n" +
                "\t<film gatunek=\"komedia\">\n" +
                "\t\t<id>1</id>\n" +
                "\t\t<nazwa>Forrest Gump</nazwa>\n" +
                "\t\t<ocena>7</ocena>\n" +
                "\t</film>\n" +
                "\t<film gatunek=\"komedia\">\n" +
                "\t\t<id>2</id>\n" +
                "\t\t<nazwa>American Pie</nazwa>\n" +
                "\t\t<ocena>9</ocena>\n" +
                "\t</film>\n" +
                "\t<film gatunek=\"dramat\">\n" +
                "\t\t<id>3</id>\n" +
                "\t\t<nazwa>Zielona Mila</nazwa>\n" +
                "\t\t<ocena>10</ocena>\n" +
                "\t</film>\n" +
                "</filmy>";

        String tytulFilmu = XmlPath.from(xml).get("filmy.film.nazwa[0]"); // pierwszy tytuł filmu
        List<String> tytuły = XmlPath.from(xml).getList("filmy.film.nazwa"); // lista tytułów
        List<String> tytulyCollect = XmlPath.from(xml).get("filmy.film.collect {it.nazwa}"); // alternatywna lista tytułów

        String gatunek = XmlPath.from(xml).get("filmy.film[0].@gatunek"); // pobranie wartości atrybutu gatunek dla pola film dla pierwszego filmu

        List<Node> galezieFilmu = XmlPath.from(xml).get("filmy.film.findAll {element -> return element}"); // znajduje wszystkie elementy gałęzi Film
        String tytul = galezieFilmu.get(2).get("nazwa").toString(); // z tej listy pobierze drugą nazwe filmu

        List<Node> komedie = XmlPath.from(xml).get("filmy.film.findAll {film -> film.@gatunek=='komedia'}"); // odszuka wszystkie info o filmach, które mają atrybut gatunek = komedia

        Node film10 = XmlPath.from(xml).get("filmy.film.find {film -> def ocena = film.ocena; ocena=='10' }"); // odszuka 1 film, który ma ocenę = 10; def ocena to zmienna o nazwie - ocena
        List<Node> filmWiecej7 = XmlPath.from(xml).get("filmy.film.findAll {film -> def ocena = film.ocena.toFloat(); ocena>7}");
    }
}
