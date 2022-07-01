import io.restassured.http.ContentType;
import model.BodyModel;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

// PUT - aktualizacja całego wpisu

public class PUTobjectFromClass {

    @Test
    public static void putObjectFromClass() {

        // z modelu BodyModel
        // jak nie podamy jakiegoś pola to ustawimy dla niego null bo jest to pole w body klasy PutModel pole istnieje z domyślnym null
        // aby unikąć null i nie skasować wartości jakiegoś pola w klasie BodyModel ustawia się @JsonInclude(JsonInclude.Include.NON_NULL)
        BodyModel bodyPut = new BodyModel(); // odwołanie do klasy z modelu
        bodyPut.setTitle("hej");
        bodyPut.setAuthor("hejbody");

        given().log().all() //pozwoli sprawdzić co dokładnie wysłaliśmy z jakimi parametrami
               .contentType(ContentType.JSON) // należy ustawić właściwy content type
               .body(bodyPut)
        .when().put("http://localhost:3000/posts/1") // metoda PUT
        .then().log().all();
    }
}
