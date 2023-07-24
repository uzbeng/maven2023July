package utilities;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public String path;
	public FileInputStream fis = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFCell cell = null;

	public ExcelReader(String path, String sheetName) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Object[][] getTableData(String tableNameProvided) {
		int rowCount = sheet.getLastRowNum() + 1;
		int tableDataStartsAtRow = 0;
		int tableDataEndsAtRow = 0;
		int tableColumnsSize = 0;
		int totalNumOfTableRows = 0;

		for (int i = 0; i < rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			if (row != null && !row.getCell(0).getStringCellValue().isEmpty()) {
				String tableName = row.getCell(0).getStringCellValue();

				if (tableName != null && !tableName.isEmpty() && tableName.equalsIgnoreCase(tableNameProvided)) {
					tableDataStartsAtRow = i + 2;
					XSSFRow dataRow1 = sheet.getRow(tableDataStartsAtRow);
					tableColumnsSize = dataRow1.getLastCellNum();
				}
			}
		}

		for (int i = tableDataStartsAtRow; i <= rowCount + 1; i++) {
			XSSFRow row = sheet.getRow(i);
			if (row == null || row.getCell(0).getStringCellValue().isEmpty()) {
				tableDataEndsAtRow = i - 1;
				break;

			}
		}

		totalNumOfTableRows = tableDataEndsAtRow - tableDataStartsAtRow + 1;
//		System.out.println("counts: " + rowCount +" " +tableDataStartsAtRow+" " + tableDataEndsAtRow+" " + tableColumnsSize+" " + totalNumOfTableRows);
		
		Object[][] tableData = new Object[totalNumOfTableRows][tableColumnsSize];
		

		// Get the table data
		// Loop each row
		for (int i = tableDataStartsAtRow, k=0; i <= tableDataEndsAtRow; i++, k++) {
			XSSFRow row = sheet.getRow(i);

			// Loop each column
			for (int j = 0; j < tableColumnsSize; j++) {
				tableData[k][j] = row.getCell(j).getStringCellValue();				
			}
		}

		return tableData;
	}	
	
	public static void main(String[] args) {
		ExcelReader excelReader = new ExcelReader("src\\main\\java\\excel\\Book1.xlsx", "Sheet1");
		Object[][] data = excelReader.getTableData("Table1");
		System.out.println(data[0][0]);
	}

}
