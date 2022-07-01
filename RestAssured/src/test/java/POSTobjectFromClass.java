import io.restassured.http.ContentType;
import model.BodyModel;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

// POST - nowy wpis

public class POSTobjectFromClass {

    @Test
    public static void postObjectFromClass() {

        // z modelu BodyModel

        BodyModel bodyNewPost = new BodyModel(); // odwołanie do klasy z modelu
        bodyNewPost.setTitle("hej");
        bodyNewPost.setAuthor("hejauthor");

        given().log().all() //pozwoli sprawdzić co dokładnie wysłaliśmy z jakimi parametrami
               .contentType(ContentType.JSON) // należy ustawić właściwy content type
               .body(bodyNewPost)
        .when().post("http://localhost:3000/posts") // metoda POST
        .then().log().all();
    }
}
