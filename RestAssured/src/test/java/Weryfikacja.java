import model.BodyModel;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class Weryfikacja {

    @Test
    public void weryfikacjaKoduStatusu(){

        Map<String, Object> params = new HashMap<>();
        params.put("id", "2");
        params.put("title", "what");

        given().log().all().queryParams(params)
                .when().get("http://localhost:3000/posts")
                .then().log().all().statusCode(Matchers.equalTo(200)); // Matchers do porównywania i status code
    }

    @Test
    public void weryfikacjaStatusu(){

        Map<String, Object> params = new HashMap<>();
        params.put("id", "2");
        params.put("title", "what");

        given().log().all().queryParams(params)
                .when().get("http://localhost:3000/posts")
                .then().log().all().statusLine(Matchers.containsString("OK")); // OK bo status 200 ma OK w stringu
    }

    @Test
    public void weryfikacjaResponseBody(){

        // całe body
        String spodziewany= """
                {
                    "title": "hej",
                    "author": "hejbody",
                    "id": 1
                }""";

        given().log().all()
                .when().get("http://localhost:3000/posts/1")
                .then().log().all().body(Matchers.equalTo(spodziewany)); //body
    }

    @Test
    public void weryfikacjaResponseString(){

        // jakiś string w całym body
        given().log().all()
                .when().get("http://localhost:3000/posts/1")
                .then().log().all().body(Matchers.containsString("hej")); //body contains string

    }

    @Test
    public void weryfikacjaWartosciPola(){

        // jakiś string z konkretnego pola
        given().log().all()
                .when().get("http://localhost:3000/posts/2")
                .then().log().all().body("title",Matchers.equalTo("what")) //podajemy nazwę pola a następnie wartość jaką szukamy
                .and().body("id",Matchers.equalTo(2)); // and jako dodatkowy warunek

    }

    @Test
    public void weryfikacjaBodyKlasyModel(){

        Integer id = 2;

        // weryfikacja pól wg klasy z model

        BodyModel pobierz =
        given().log().all()
                .when().get("http://localhost:3000/posts/2")
                .then().log().all()
                .extract().as(BodyModel.class); // mapujemy ciało odpowiedzi do modelu body z klasy GetModel

        // robimy asercje na poszczególne pola
        Assert.assertEquals(pobierz.getTitle(),"what");
        Assert.assertEquals(pobierz.getId(),id); // id ze zmiennej int

    }
}
