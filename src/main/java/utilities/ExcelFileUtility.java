package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	public String readDataFromExcel(String fileLoc, String sheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fis=new FileInputStream(fileLoc);
		String value=WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
	}
}
