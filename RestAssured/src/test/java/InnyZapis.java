import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class InnyZapis {

    @Test
    public void response(){
/*
        Response odpowiedz = RestAssured.get("http://localhost:3000/posts/1");
        String poleAuthor = odpowiedz.path("author"); // path oznaczamy o które pole nam chodzi

        Assert.assertEquals(poleAuthor,"dic");
        */

        // inny zapis
        String poleAuthor2 = RestAssured.get("http://localhost:3000/posts/1").path("author");
        Assert.assertEquals(poleAuthor2,"hejbody");
    }

    @Test
    public void jasonPath(){
/*

        Response odpowiedz = RestAssured.get("http://localhost:3000/posts/1");
        JsonPath jason = new JsonPath(odpowiedz.asString());

        String poleAuthor = jason.get("author"); // path oznaczamy o które pole nam chodzi

        Assert.assertEquals(poleAuthor,"hejbody");
*/

        // inny zapis
        String response = RestAssured.get("http://localhost:3000/posts/1").asString();
        String poleAuthor2 = JsonPath.from(response).get("author");

        Assert.assertEquals(poleAuthor2,"hejbody");

    }
}
