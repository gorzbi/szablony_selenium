package POPexcel.smieciowy;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class czytaczExcel {

    @Test

    public static void readExcel() throws IOException {

        // Import Excel file
        File sciezkaPliku = new File("src/test/resources/testData.xlsx");

        // Load the file
        FileInputStream loadPlik = new FileInputStream(sciezkaPliku);

        // Load the workbook
        Workbook workbook = new XSSFWorkbook(loadPlik);

        // pobieramy pierwszy arkusz z pliku
        Sheet arkusz = workbook.getSheetAt(0);

        int rowCount = arkusz.getLastRowNum(); // sprawdzamy ile jest wierszy w pliku

        for (int i = 1; i <= rowCount; i++) {
            Row wiersz = arkusz.getRow(i); // pobieramy poszczególne wiersze

            String kol1 = wiersz.getCell(0).getStringCellValue(); // pobieramy wartości z pierwszej kolumny (w pliku jest tylko 1 kolumna)
            String kol2 = wiersz.getCell(1).getStringCellValue(); // jakby była druga kolumna

            System.out.println(kol1);
            System.out.println(kol2);

        }
    }

    public static void main(String[] args) throws IOException {
        readExcel();
    }
}