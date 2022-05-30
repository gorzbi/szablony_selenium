package tools;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ScreenElement {

    private static String screenElementu(WebDriver driver, WebElement element, String jira, String nazwa) throws IOException {

        String nazwaScreenElementu = "ScreenElement" + nazwa +".png";

        // zainicjowanie robienia screena dla elementu
        Screenshot elementScreen = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1)).takeScreenshot(driver, element);
        String path = "src/resources/screeny/"+jira+"/"+nazwaScreenElementu;
        ImageIO.write(elementScreen.getImage(), "PNG", new File(path));
        return path;
    }

    // pobranie screena
    public static Media getElementScreenshot(WebDriver driver, WebElement element, String jira, String nazwa) throws IOException {
        String path2 = screenElementu(driver, element, jira, nazwa);
        return MediaEntityBuilder.createScreenCaptureFromPath(path2).build();
    }
}
