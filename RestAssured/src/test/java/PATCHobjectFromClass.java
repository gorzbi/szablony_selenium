import io.restassured.http.ContentType;
import model.PutModel;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

// PATCH - aktualizacja wybranego elementu wpisu

public class PATCHobjectFromClass {

    @Test
    public static void patchObjectFromClass() {

        // z modelu Put
        // jak nie podamy jakiegoś pola to ustawimy dla niego null bo jest to pole w body klasy PutModel pole istnieje z domyślnym null
        // aby unikąć null i nie skasować wartości jakiegoś pola w klasie PutModel ustawia się @JsonInclude(JsonInclude.Include.NON_NULL)
        PutModel bodyPut = new PutModel(); // odwołanie do klasy z modelu
        bodyPut.setUserId(120);

        given().log().all() //pozwoli sprawdzić co dokładnie wysłaliśmy z jakimi parametrami
               .contentType(ContentType.JSON) // należy ustawić właściwy content type
               .body(bodyPut)
        .when().patch("https://jsonplaceholder.typicode.com/posts/1") // metoda PATCH
        .then().log().all();
    }
}
