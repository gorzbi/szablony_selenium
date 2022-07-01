import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PathParams {

    @Test
    public static void pathParams() {

        //given().when().get("http://localhost:3000/posts/1").then().log().all();// na sztywno wpisany id posta

       // given().pathParam("id",1) // path params ze zmienną id = 1
               // .when().get("http://localhost:3000/posts/{id}").then().log().all(); // odwołanie do id


        given().when().get("http://localhost:3000/posts/{id}",1).then().log().all(); // zmienna id z wartością

    }
}
