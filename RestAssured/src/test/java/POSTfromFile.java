import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class POSTfromFile {

    @Test
    public static void post() {

        File cialoRequesta = new File("src/test/resources/body.json");

        given()
                .log().all() //pozwoli sprawdzić co dokładnie wysłaliśmy z jakimi parametrami
                .contentType(ContentType.JSON) // należy ustawić właściwy content type
                .body(cialoRequesta)
        .when().post("https://jsonplaceholder.typicode.com/posts")
        .then().log().all();
    }
}
