import org.testng.annotations.Test;
import static io.restassured.RestAssured.when;

public class GET {

    @Test
    public void get() {

        System.out.println("Nic nie wyświetli");
        when().get("http://localhost:3000/posts/1"); // tu wykona tylko request ale nic nam nie wyświetli

        System.out.println("Teraz wyświetli body response:");
        when().get("http://localhost:3000/posts/1").then().log().body(); // nie sprawdza jaki jest status, albo co jest w body

        System.out.println("Teraz wyświetli dodatkowo headers:");
        when().get("http://localhost:3000/posts/1").then().log().all();

        System.out.println("Z walidacją i jaki status się spodziewamy:");
        when().get("http://localhost:3000/posts/1").then().log().ifValidationFails().statusCode(404); //będzie błąd bo oczekujemy 404 a będzie 200

    }
}
