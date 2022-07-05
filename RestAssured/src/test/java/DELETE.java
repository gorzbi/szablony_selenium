import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class DELETE {

    @Test
    public void delete() {

        // jeśli usuwamy nieistniejący zasób to w odpowiedzi dostaniemy 404, test zakończy się sukcesem bo nic nie jest weryfikowane

        when().delete("http://localhost:3000/posts/2") // metoda DELETE
                .then().log().all(); // w response body będzie pusto
    }
}
