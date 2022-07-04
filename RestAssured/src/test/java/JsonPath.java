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
        Map<String,?> winnerAllFields = odpowiedz.path("winners[0]"); // wszystkie pola pierwszego winnera; String bo nazwa pola jest stringiem, ? bo wartości mogą być strinkiem, int i inne
        List<Map<String,?>> allWinners = odpowiedz.path("winners"); // wszyscy ze wszystkimi polami

        Map<String,?> winnerInfo = odpowiedz.path("winners.find {it.name=='John'}"); // w winnersach find szuka i zwraca tylko 1 element ten pierwszy, it wszędzie pola name z wartością John
        Integer winnerId = odpowiedz.path("winners.find {it.name=='John'}.winnerId"); // wyciągnie winnerId z winnersów gdzie imie to John
        Integer maxWinningNumber = odpowiedz.path("winning-numbers.max()"); // max/min liczba ze zbioru
        Map<String,?> maxWinnerId = odpowiedz.path("winners.max {it.winnerId}"); // wyciągnie całe info o osobie o max id ze zbioru winners
        Integer moneySum = odpowiedz.path("winners.collect {it.money}.sum()"); // suma money ze zbioru winners
        List<Integer> winnersId = odpowiedz.path("winners.findAll {it.name=='John'}.winnerId"); // dla listy integerów findAll wyszuka wszystkie elementy
    }
}
