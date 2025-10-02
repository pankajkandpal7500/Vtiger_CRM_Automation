package baseutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import generic_utility.FileUtility;
import generic_utility.WebdriverUtility;

public class baseclass {
		
	public WebDriver driver=null;
	public static WebDriver sdriver;
	@BeforeSuite
	public void dbConn() {
		
	}
	
	@BeforeTest
	public void preCon() {
	System.out.println("Pre Conditions ");	
	}
	
	@BeforeClass
	public void openBro() throws IOException {
		FileUtility fUtil= new FileUtility();
		
		String Browser = fUtil.getDataFromProperties("bro");
		if(Browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}else if(Browser.equals("edge")) {
			
			driver=new EdgeDriver();
			
		}
		else if(Browser.equals("firefox")){
			driver=new FirefoxDriver();
			
		}else {
			
			driver=new ChromeDriver();
		}
		sdriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	}
	
	public void login() throws IOException {
		FileUtility fUtil= new FileUtility();
		String URL = fUtil.getDataFromProperties("url");
		String USERNAME=fUtil.getDataFromProperties("un");
		String PASSWORD=fUtil.getDataFromProperties("pwd");
		
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.loginToCRM(USERNAME, PASSWORD);				
	}
	
	@AfterMethod
	public void logOut() {
		HomePage hp= new HomePage(driver);
		WebElement profile = hp.getProfile();
		WebdriverUtility wdUtil = new WebdriverUtility(driver);
		wdUtil.hover(profile);
		hp.getSignOut().click();	
	}
	
	@AfterClass
	public void closeBro() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	@AfterTest
	public void postCon() {
		System.out.println("Post conditions");
	}
	
	@AfterSuite
	public void dbClose() {
		
	}
	
	
}
