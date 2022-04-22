import static io.restassured.RestAssured.when;

public class GET {

    public static void main(String[] args) {
        System.out.println("Nic nie wyświetli");
        when().get("https://jsonplaceholder.typicode.com/posts/1"); // tu wykona tylko request ale nic nam nie wyświetli

        System.out.println("Teraz wyświetli body response:");
        when().get("https://jsonplaceholder.typicode.com/posts/1").then().log().body();


        System.out.println("Teraz wyświetli dodatkowo headers:");
        when().get("https://jsonplaceholder.typicode.com/posts/1").then().log().all();
    }
}
