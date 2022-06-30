import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

// POST - nowy wpis

public class POSTmap {

    @Test
    public static void postMap() {

        Map<String, Object> mapBody = new HashMap<>(); // string bo to jest opis pola, object bo pole może być stringiem, int lub inne
        mapBody.put("userID", "11");
        mapBody.put("title", "cos");
        mapBody.put("body", "cos");

        given()
                .log().all() //pozwoli sprawdzić co dokładnie wysłaliśmy z jakimi parametrami
                .contentType(ContentType.JSON) // należy ustawić właściwy content type
                .body(mapBody)
                .when().post("https://jsonplaceholder.typicode.com/posts") // metoda POST
                .then().log().all();
    }
}
