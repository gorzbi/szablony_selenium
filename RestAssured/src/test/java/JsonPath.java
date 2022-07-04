import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class JsonPath {

    @Test
    public void response(){

        Response odpowiedz = RestAssured.get("http://localhost:3000/posts/1");

        System.out.println(odpowiedz.asString());

        String secret = odpowiedz.path("secret"); // pobieramy pole secret
        List<Integer> winningNb = odpowiedz.path("winning-numbers"); // pobieramy listę, która jest cyframi
        String firstWinnerName = odpowiedz.path("winners.name[0]"); // 0 - pierwsze imię na liście winnersów
        String firstWinnerName1 = odpowiedz.path("winners[0].name"); // alternatywny zapis
        String lastWinnerName = odpowiedz.path("winners.name[-1]"); // -1 to ostatnie imię na liście winnersów
        List<String> winnersNames = odpowiedz.path("winners.name"); // lista imion z winnersów
        Map<String,?> winnerAllFields = odpowiedz.path("winners[0]"); // wszystkie pola pierwszego winnera
        List<Map<String,?>> allWinners = odpowiedz.path("winners"); // wszyscy ze wszystkimi polami

    }
}
