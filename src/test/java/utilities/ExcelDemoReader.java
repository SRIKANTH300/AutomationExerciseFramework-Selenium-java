package utilities;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Simple demo to verify ExcelUtils reads the TestData.xlsx file.
 * Run this as a Java application from Eclipse (run as -> Java Application) or as a test helper.
 */
public class ExcelDemoReader {

    public static void main(String[] args) {
        String excelPath = "src/test/resources/testdata/TestData.xlsx";
        String sheetName = "LoginTestData";

        ExcelUtils excel = new ExcelUtils();
        try {
            excel.loadExcel(excelPath, sheetName);

            System.out.println("Loaded: " + excelPath + " (sheet: " + sheetName + ")");
            System.out.println("Total rows (including header): " + excel.getRowCount());
            System.out.println("Data rows: " + excel.getDataRowCount());
            System.out.println("Columns: " + excel.getColumnCount());

            // print header
            List<String> header = excel.readRow(0);
            System.out.println("Header: " + header);

            // print all data rows as maps
            List<Map<String, String>> all = excel.readAllDataAsMaps();
            int r = 1;
            for (Map<String, String> row : all) {
                System.out.println("Row " + r + ": " + row);
                r++;
            }

        } catch (IOException e) {
            System.err.println("I/O error while reading Excel: " + e.getMessage());
            e.printStackTrace();
        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                excel.closeWorkbook();
            } catch (IOException e) {
                // ignore
            }
        }
    }
}
