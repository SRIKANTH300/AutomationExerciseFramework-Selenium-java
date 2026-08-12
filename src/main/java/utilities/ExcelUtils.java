package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    private final DataFormatter formatter = new DataFormatter();

    // Load Excel file and select sheet
    public void loadExcel(String filePath, String sheetName) throws IOException {

        try (FileInputStream fis = new FileInputStream(filePath)) {

            workbook = new XSSFWorkbook(fis);

            sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                workbook.close();
                workbook = null;

                throw new IllegalArgumentException(
                        "Sheet '" + sheetName + "' not found in Excel file."
                );
            }
        }
    }

    // Select a sheet from already loaded workbook
    public void selectSheet(String sheetName) {

        ensureWorkbookOpen();

        XSSFSheet selectedSheet = workbook.getSheet(sheetName);

        if (selectedSheet == null) {
            throw new IllegalArgumentException(
                    "Sheet '" + sheetName + "' not found."
            );
        }

        sheet = selectedSheet;
    }

    // Check whether workbook and sheet are loaded
    private void ensureWorkbookOpen() {

        if (workbook == null || sheet == null) {
            throw new IllegalStateException(
                    "Workbook or sheet is not loaded. Call loadExcel() first."
            );
        }
    }

    // Get total number of rows
    public int getRowCount() {

        ensureWorkbookOpen();

        return sheet.getPhysicalNumberOfRows();
    }

    // Get number of data rows excluding header
    public int getDataRowCount() {

        int totalRows = getRowCount();

        return Math.max(0, totalRows - 1);
    }

    // Get number of columns
    public int getColumnCount() {

        ensureWorkbookOpen();

        Row header = sheet.getRow(0);

        if (header == null) {
            return 0;
        }

        return header.getPhysicalNumberOfCells();
    }

    // Get data from a particular cell
    public String getCellData(int rowIndex, int colIndex) {

        ensureWorkbookOpen();

        Row row = sheet.getRow(rowIndex);

        if (row == null) {
            return "";
        }

        Cell cell = row.getCell(colIndex);

        if (cell == null) {
            return "";
        }

        return formatter.formatCellValue(cell);
    }

    // Read complete row
    public List<String> readRow(int rowIndex) {

        ensureWorkbookOpen();

        List<String> values = new ArrayList<>();

        int columns = getColumnCount();

        for (int column = 0; column < columns; column++) {

            values.add(getCellData(rowIndex, column));
        }

        return values;
    }

    // Read row as Header -> Value
    public Map<String, String> readRowAsMap(int rowIndex) {

        ensureWorkbookOpen();

        Map<String, String> map = new HashMap<>();

        Row header = sheet.getRow(0);

        if (header == null) {
            return map;
        }

        int columns = getColumnCount();

        for (int column = 0; column < columns; column++) {

            Cell headerCell = header.getCell(column);

            String key;

            if (headerCell == null) {
                key = "Column" + column;
            } else {
                key = formatter.formatCellValue(headerCell);
            }

            String value = getCellData(rowIndex, column);

            map.put(key, value);
        }

        return map;
    }

    // Read all rows excluding header
    public List<Map<String, String>> readAllDataAsMaps() {

        ensureWorkbookOpen();

        List<Map<String, String>> allData = new ArrayList<>();

        int totalRows = getRowCount();

        for (int row = 1; row < totalRows; row++) {

            allData.add(readRowAsMap(row));
        }

        return allData;
    }

    // Close Excel workbook
    public void closeWorkbook() throws IOException {

        if (workbook != null) {

            workbook.close();

            workbook = null;
            sheet = null;
        }
    }
}