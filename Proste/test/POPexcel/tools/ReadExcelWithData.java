package POPexcel.tools;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelWithData {

    @Test
    public static Object[][] readExcel() throws IOException {

        // Import Excel file
        File sciezkaPliku = new File("src/test/resources/testData.xlsx");

        // Load the file
        FileInputStream loadPlik = new FileInputStream(sciezkaPliku);

        // Load the workbook
        Workbook workbook = new XSSFWorkbook(loadPlik);

        // pobieramy pierwszy arkusz z pliku
        Sheet arkusz = workbook.getSheetAt(0);

        int rowCount = arkusz.getLastRowNum(); // sprawdzamy ile jest wierszy w pliku
        int kolCount = arkusz.getRow(0).getLastCellNum(); // sprawdzamy ile jest kolumn
        Object[][] data = new Object[rowCount][kolCount];

        for (int i = 1; i <= rowCount; i++) {
            Row wiersz = arkusz.getRow(i); // pobieramy poszczególne wiersze

            for (int j=0; j<=kolCount; j++) {
                data[i-1][j] = wiersz.getCell(j).getStringCellValue(); // pobieramy wartości z kolumn
            }
        }
        return data;
    }
}