package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.Test;

public class DeklaracjaRaportu {

    @Test
    public void test() {

        ExtentReports extent = new ExtentReports(); // tworzymy obiekt

        // konfiguracja raportu
        ExtentSparkReporter spark = new ExtentSparkReporter("C:/Users/zbigniew.gornowicz/Desktop/deklaracja_raportu.html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setReportName("Nazwa raportu");
        spark.config().setDocumentTitle("Nazwa dokumentu");
        extent.attachReporter(spark);

        // case 01

        ExtentTest test01 = extent.createTest("Przypadek 01");
        test01.info("Info, że zaczynam test");
        test01.pass("Pass jeśli pierwszy krok jest ok");
        test01.pass("Pass jeśli kolejny krok jest ok");
        test01.fail("Fail, że krok nie zostal wykonany więc też ok");
        test01.info("Info, że koniec testu");

        // wykonanie raportu
        extent.flush();
    }

}
