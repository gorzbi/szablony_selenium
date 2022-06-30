import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PUTmap {

    @Test
    public static void putMap() {

        // jak nie podamy jakiegoś pola to PUT go usunie w aktualizowanym wpisie
        Map<String, Object> mapBody = new HashMap<>(); // string bo to jest opis pola, object bo pole może być stringiem, int lub inne
        mapBody.put("userID", "11");
        mapBody.put("title", "cos");
        mapBody.put("body", "cos");

        given()
                .log().all() //pozwoli sprawdzić co dokładnie wysłaliśmy z jakimi parametrami
                .contentType(ContentType.JSON) // należy ustawić właściwy content type
                .body(mapBody)
        .when().put("https://jsonplaceholder.typicode.com/posts/1") // metoda PUT
        .then().log().all();
    }
}
