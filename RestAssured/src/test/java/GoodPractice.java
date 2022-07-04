import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GoodPractice {

    @Test
    public void czytelnoscKodu(){

        // czytelne ułożenie kodu
        given()
                .log().all().
        when()
                .get("http://localhost:3000/posts/2").
        then()
                .log().all().body("title", equalTo("what")). //podajemy nazwę pola a następnie wartość jaką szukamy
        and()
                .body("id", equalTo(2)); // and jako dodatkowy warunek

    }

    @Test
    public void skracanieKodu(){

        // czytelne ułożenie kodu
        // Marchers zamienione na import static equalTo
        given().
                log().all().
        when()
                .get("http://localhost:3000/posts/2").
        then()
                .log().all()
                .assertThat().body("title",equalTo("what")). //podajemy nazwę pola a następnie wartość jaką szukamy
        and()
                .assertThat().body("id", equalTo(2)); // and jako dodatkowy warunek

    }
}
