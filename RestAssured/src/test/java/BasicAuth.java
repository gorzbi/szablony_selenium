import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class BasicAuth {

    @Test
    public void basicAuth() {

        // autoryzacja w sekcji given

        given()
                //.auth().preemptive() - niektóre endpointy sprawdzają najpierw samo logowanie i wówczas jest to potrzebne, dodatkowe info w head
                .auth()
                .basic("postman","password").

        when()
                .get("https://postman-echo.com/basic-auth").
        then()
                .log().all();
    }
}
