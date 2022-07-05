import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.when;

public class TimeResponse {

    @Test
    public static void time() {

        long time = when().get("http://localhost:3000/posts/1").timeIn(TimeUnit.MILLISECONDS);
        System.out.println(time);

        // sprawdzamy czy odpowiedź jest poniżej 2000ms
        when().
                get("http://localhost:3000/posts/1").
        then().
                time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS); // czas z L bo integer

    }
}
