import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class Filtry {

    @Test
    public void filtry(){

        // z jednym parametrem np. id
        given().log().all().queryParam("id",1,2)
                .when().get("https://jsonplaceholder.typicode.com/posts/").then().log().all();

    }

    @Test
    public void filtryKilka(){

        // dla kilku parametrów np. id + title, wszystkie muszą być spełnione dla danego wpisu
        Map<String, Object> params = new HashMap<>(); // string bo to jest opis pola, object bo pole może być stringiem, int lub inne
        params.put("id", "2");
        params.put("title", "qui est esse");


        given().log().all().queryParams(params)
                .when().get("https://jsonplaceholder.typicode.com/posts").then().log().all();
    }
}
