package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	public String getDataFromProperties(String key) throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\HP\\Pictures\\javaprograms\\SeleniumProjectWinners\\my-testcases\\src\\test\\resource\\commomdata.properties");
		
		Properties pobj = new Properties();
		pobj.load(fis);
		// step 3> get the value by passing the keys
				String BROWSER = pobj.getProperty("bro");
				String URL = pobj.getProperty("url");
				String USERNAME = pobj.getProperty("un");
				String PASSWORD = pobj.getProperty("pwd");
		String value = pobj.getProperty(key);
		return value;
	}

	public String  getDataFromexcelFile(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis1 = new FileInputStream(
				"C:\\Users\\HP\\Pictures\\javaprograms\\SeleniumProjectWinners\\my-testcases\\src\\test\\resource\\TestOne.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet  sh = wb.getSheet("Sheet1");
		String  value=sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;			
	}
	public int getNumericDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis1 = new FileInputStream(
				"C:\\Users\\HP\\Pictures\\javaprograms\\SeleniumProjectWinners\\my-testcases\\src\\test\\resource\\TestOne.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet  sh = wb.getSheet("Sheet1");
		int value = (int) sh.getRow(rowNum).getCell(cellNum).getNumericCellValue();
		return value;	
		
	}
}
