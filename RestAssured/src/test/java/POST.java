import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

// POST - nowy wpis

public class POST {

    @Test
    public static void post() {

        String cialoRequesta = """
                {
                    "title": "new",
                    "author": "post"
                }""";

        given()
                .log().all() //pozwoli sprawdzić co dokładnie wysłaliśmy z jakimi parametrami
                .contentType(ContentType.JSON) // należy ustawić właściwy content type
                .body(cialoRequesta)
        .when().post("http://localhost:3000/posts") // metoda POST
        .then().log().all();

    }
}
