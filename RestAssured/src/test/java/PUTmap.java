import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

// PUT - aktualizacja całego wpisu

public class PUTmap {

    @Test
    public static void putMap() {

        // jak nie podamy jakiegoś pola to PUT go usunie w aktualizowanym wpisie
        Map<String, Object> mapBody = new HashMap<>(); // string bo to jest nazwa pola, object bo pole może być stringiem, int lub inne
        mapBody.put("title", "perke");
        //mapBody.put("author", "perke");

        given()
                .log().all() //pozwoli sprawdzić co dokładnie wysłaliśmy z jakimi parametrami
                .contentType(ContentType.JSON) // należy ustawić właściwy content type
                .body(mapBody)
        .when().put("http://localhost:3000/posts/1") // metoda PUT
        .then().log().all();
    }
}
