package VtigerCRM;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\HP\\Pictures\\javaprograms\\SeleniumProjectWinners\\my-testcases\\src\\test\\resource\\TestData.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		//create method will not create anything it will open workbook in Read mode
		
		Sheet sh = wb.getSheet("File1");
		Row row = sh.getRow(1);
		Cell cell = row.getCell(1);
		String data = cell.getStringCellValue();
		
		//System.out.println(data + (int)(Math.random() * 999));
		//System.out.println(row);
		int lastRow = sh.getLastRowNum();
		//System.out.println(lastRow);
		
		for (int i = 1; i <= lastRow; i++) {
			String v1 = sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println(v1);
		}
		wb.close();	
	}

}
