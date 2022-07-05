import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RequestResponseSpecification {

    @Test
    public void get() {

        given().
                baseUri("http://localhost:3000").
                basePath("posts").
        when().
                get("/1").
        then().
                log().body();
    }

    //------------------inny zapis---------------------

    RequestSpecification req; // tworzymy pole, które będzie wykorzystywane jako zmienna w metodzie dla requesta
    ResponseSpecification resp;

    @BeforeClass
    public void base() {

        // utworzenie wspólnego elementu dla wielu requestów wywoływany przed testem

        req = new RequestSpecBuilder().
                setBaseUri("http://localhost:3000").
                setBasePath("posts").
                build();


        // utworzenie wspólnego elementu dla wielu responsów wywoływany przed testem

        resp = new ResponseSpecBuilder().
                expectStatusCode(200).
                build();
    }

    @Test
    public void get2() {

        given().
                spec(req). // baseUri+basePath
        when().
                get("/1").
        then().
                log().body().spec(resp);
    }
}
