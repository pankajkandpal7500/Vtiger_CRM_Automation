package VtigerCRM;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Learn {

	public static void main(String[]args) throws IOException {
		//Step 1> Get the java representation object of the physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Pictures\\javaprograms\\SeleniumProjectWinners\\my-testcases\\src\\test\\resource\\commomdata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		
		//step 3> get the value by passing the keys
		String BROWSER = pobj.getProperty("bro");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("un");
		String PASSWORD = pobj.getProperty("pwd");
		
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
		
		}

}
