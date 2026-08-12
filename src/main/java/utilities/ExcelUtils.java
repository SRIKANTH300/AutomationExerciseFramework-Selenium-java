package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public void loadExcel(String filePath, String sheetName)
            throws IOException {

        FileInputStream fis = new FileInputStream(filePath);

        workbook = new XSSFWorkbook(fis);

        sheet = workbook.getSheet(sheetName);

        fis.close();
    }

    public int getRowCount() {

        return sheet.getPhysicalNumberOfRows();
    }

    public int getColumnCount() {

        return sheet.getRow(0).getPhysicalNumberOfCells();
    }

    public String getCellData(int row, int column) {

        return sheet
                .getRow(row)
                .getCell(column)
                .toString();
    }

    public void closeWorkbook() throws IOException {

        if (workbook != null) {
            workbook.close();
        }
    }
}