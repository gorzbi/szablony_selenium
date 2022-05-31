package Tools;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FullScreen {

    public static String timestamp() {

        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }
    
    // full screen -> zapis wszystkich screenów do jednego folderu


    private static String getFullScreen(WebDriver browser) throws IOException {

        String nazwaFullScreena = "fullScreen" + timestamp()+".png";

        // zainicjowanie robienia screena - full web
        Screenshot fullScreen = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(5)).takeScreenshot(browser);
        String path = "src/screeny/"+nazwaFullScreena; // folder istnieje
        ImageIO.write(fullScreen.getImage(), "PNG", new File(path));
        return path;
    }


    // pobranie screena

    public static Media getFullScreenshot(WebDriver browser) throws IOException {

        String path2 = getFullScreen(browser);
        return MediaEntityBuilder.createScreenCaptureFromPath(path2).build();
    }
    
    
    
    // v2 full screen -> zapis screenów do poszczególnych folderów, nazwa folderu jako parametr "nazwa" podawany jako string w klasie testowej

    private static String pelnyScreen(WebDriver driver, String jira, String nazwa) throws IOException {
        
        String nazwaFullScreena = nazwa +".png";

        // zainicjowanie robienia screena - full web
        Screenshot fullScreen = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(5)).takeScreenshot(driver);
        File outFile = new File("src/resources/screeny/"+jira+"/"+nazwaFullScreena);
        File parentDir = outFile.getParentFile(); // pobranie powyższej ścieżki
        parentDir.mkdirs(); // utworzenie ścieżki, jej brakujacych folderów/podfolderów
        ImageIO.write(fullScreen.getImage(), "PNG", outFile);
        return outFile.getPath(); // pobranie pełnej ścieżki do screena
    }

    // pobranie screena
    public static Media getFullScreenshot(WebDriver driver, String jira, String nazwa) throws IOException {
        String path2 = pelnyScreen(driver, jira, nazwa);
        return MediaEntityBuilder.createScreenCaptureFromPath(path2).build();
    }

}
