package Tools;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screen {

    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    // metody do robienia screena i zapisu

    private static String zrzutEkranu(WebDriver browser) throws IOException {

        // nadanie nazwy dla screena
        String nazwaScreena = "screen" + timestamp()+".png";

        // zrobienie screena
        TakesScreenshot screenshot = (TakesScreenshot) browser;
        File plik = screenshot.getScreenshotAs(OutputType.FILE);
        String sciezkaScreena = "src/screeny/"+nazwaScreena;
        FileUtils.copyFile(plik, new File(sciezkaScreena));
        return sciezkaScreena;
    }

    // pobranie screena

    public static Media getScreenschot(WebDriver browser) throws IOException {

        String sciezkaScreena = zrzutEkranu(browser);
        return MediaEntityBuilder.createScreenCaptureFromPath(sciezkaScreena).build();
    }
}
