import io.restassured.http.ContentType;
import model.PostModel;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

// POST - nowy wpis

public class POSTobjectFromClass {

    @Test
    public static void postObjectFromClass() {

        // z modelu Post

        PostModel bodyNewPost = new PostModel(); // odwołanie do klasy z modelu
        bodyNewPost.setUserId(120);
        bodyNewPost.setTitle("hej");
        bodyNewPost.setBody("hejbody");

        given().log().all() //pozwoli sprawdzić co dokładnie wysłaliśmy z jakimi parametrami
               .contentType(ContentType.JSON) // należy ustawić właściwy content type
               .body(bodyNewPost)
        .when().post("https://jsonplaceholder.typicode.com/posts") // metoda POST
        .then().log().all();
    }
}
