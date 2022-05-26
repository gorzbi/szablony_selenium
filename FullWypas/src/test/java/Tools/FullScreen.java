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


    private static String getFullScreen(WebDriver browser) throws IOException {

        String nazwaFullScreena = "fullScreen" + timestamp()+".png";

        // zainicjowanie robienia screena - full web
        Screenshot fullScreen = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(5)).takeScreenshot(browser);
        String path = "src/screeny/" +nazwaFolderu+"/"+nazwaFullScreena;
        ImageIO.write(fullScreen.getImage(), "PNG", new File(path));
        return path;
    }


    // pobranie screena

    public static Media getFullScreenshot(WebDriver browser) throws IOException {

        String path2 = getFullScreen(browser);
        return MediaEntityBuilder.createScreenCaptureFromPath(path2).build();
    }
    
    // v2 pobranie screena

    public static Media getFullScreenshot(WebDriver browser, String nazwaFolderu, String nazwa) throws IOException {

        String path2 = getFullScreen(browser, nazwaFolderu, nazwa); // w teście w danym kroku je implementujemy nazwaFolderu to np. folder do zapisania screenów, a nazwa to nazwa którą podajemy w teście dla kroku jak ma nazywać się screen
        return MediaEntityBuilder.createScreenCaptureFromPath(path2).build();
    }

}
