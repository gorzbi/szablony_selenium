import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class POST {

    @Test
    public static void post() {

        String cialoRequesta = """
                {
                    "userId": 111,
                    "title": "elo2",
                    "body": "elo2"
                }""";

        given()
                .log().all() //pozwoli sprawdzić co dokładnie wysłaliśmy z jakimi parametrami
                .contentType(ContentType.JSON) // należy ustawić właściwy content type
                .body(cialoRequesta)
        .when().post("https://jsonplaceholder.typicode.com/posts") // metoda POST
        .then().log().all();

    }
}
