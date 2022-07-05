import io.restassured.http.ContentType;
import model.BodyModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

// POST - nowy wpis

public class POSTporownanieObject {

    @Test
    public void postObjectFromClass() {

        // z modelu BodyModel

        // 1 obiekt
        BodyModel newPost = new BodyModel(); // odwołanie do klasy z modelu
        newPost.setTitle("koszmar");
        newPost.setAuthor("desmond");

        // 2 obiekt
        BodyModel create =
        given().log().all() //pozwoli sprawdzić co dokładnie wysłaliśmy z jakimi parametrami
               .contentType(ContentType.JSON) // należy ustawić właściwy content type
               .body(newPost)
        .when().post("http://localhost:3000/posts") // metoda POST
        .then().log().all().extract().body().as(BodyModel.class);


        Assert.assertEquals(newPost,create); // porównanie obu obiektów
    }
}
