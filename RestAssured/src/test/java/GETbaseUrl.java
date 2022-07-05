import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GETbaseUrl {

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

    RequestSpecification base; // tworzymy pole, które będzie wykorzystywane w metodzie

    @BeforeClass
    public void base() {

        // utworzenie wspólnego elementu dla wielu requestów wywoływany przed testem

        base = new RequestSpecBuilder().
                setBaseUri("http://localhost:3000").
                setBasePath("posts").
                build();
    }

    @Test
    public void get2() {

        given().
                spec(base). // baseUri+basePath
        when().
                get("/1").
        then().
                log().body();
    }
}
