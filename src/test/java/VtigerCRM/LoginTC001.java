package VtigerCRM;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic_utility.FileUtility;
public class LoginTC001 {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		 
		FileUtility fUtil = new FileUtility();
		
		String BROWSER = fUtil.getDataFromProperties("bro");
		String URL = fUtil.getDataFromProperties("url");
		String USERNAME = fUtil.getDataFromProperties("un");
		String PASSWORD = fUtil.getDataFromProperties("pwd");
		
		String orgName = fUtil.getDataFromexcelFile("Org", 1, 0) + (int)(Math.random()*9999);
		System.out.println(orgName);

		WebDriver driver = null;

		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("❌ Browser not supported!");
			return;
		}
		
		//check to see comment 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		WebElement username = driver.findElement(By.xpath("//input[@name=\"user_name\"]"));
		username.sendKeys(USERNAME);
		WebElement password = driver.findElement(By.xpath("//input[@name=\"user_password\"]"));
		password.sendKeys(PASSWORD);
							
		WebElement login = driver.findElement(By.id("submitButton"));
		login.click();

		// click on organization and create organization
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// find the account element and add qspider+random 4 digit number to adjust
		String organisationname = "qspiders_" + (int) (Math.random() * 9999);
		WebElement orgField = driver.findElement(By.name("accountname"));
		orgField.sendKeys(organisationname);

		// Rating dropdown Handling
		WebElement Rate = driver.findElement(By.name("rating"));

		Select slc = new Select(Rate);

		List<WebElement> all = slc.getOptions();
		for (WebElement i : all) {
			i.click();
			System.out.println("the dropdown text are  - " + i.getText());
			Thread.sleep(2000);

		}

		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();

		// Verification.....

		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (actOrgName.equals(organisationname)) {
			System.out.println("Organization created successfully!!!");
		} else {
			System.out.println("Organization could not be created successfully!!!");
		}

		// Logout from application
		WebElement signout = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions act = new Actions(driver);
		act.moveToElement(signout).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

//		Actions act = new Actions(driver);
//		WebElement signoff = driver.findElement(By.xpath("/html/body/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/img"));

		Thread.sleep(3000);

		driver.quit();

	}

}
