package VtigerCRM;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_utility.FileUtility;
import generic_utility.WebdriverUtility;
import generic_utility.WebdriverUtility;

public class LoginTC001 {
    public static void main(String[] args) throws IOException, InterruptedException {
        
        FileUtility fUtil = new FileUtility();
        
        String BROWSER = fUtil.getDataFromProperties("bro");
        String URL = fUtil.getDataFromProperties("url");
        String USERNAME = fUtil.getDataFromProperties("un");
        String PASSWORD = fUtil.getDataFromProperties("pwd");
        
        WebDriver driver = null;

        if (BROWSER.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (BROWSER.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println(" Browser not supported!");
            return;
        }

        WebdriverUtility wUtil = new WebdriverUtility(driver);

        wUtil.maximize();
        wUtil.implicitWait();
        driver.get(URL);

        // Login
        wUtil.type(driver.findElement(By.name("user_name")), USERNAME);
        wUtil.type(driver.findElement(By.name("user_password")), PASSWORD);
        wUtil.click(driver.findElement(By.id("submitButton")));

        // Create Organization
        wUtil.click(driver.findElement(By.linkText("Organizations")));
        wUtil.click(driver.findElement(By.xpath("//img[@title='Create Organization...']")));

        String organisationname = "qspiders_" + (int)(Math.random()*9999);
        wUtil.type(driver.findElement(By.name("accountname")), organisationname);

      //Dropdown Industry 
        WebElement Industry= driver.findElement(By.xpath("//select[@name='industry']"));
        wUtil.printDropdownOptions(Industry);
//        // Dropdown Rating 
//        WebElement Rate = driver.findElement(By.name("rating"));
//        wUtil.printDropdownOptions(Rate);

        
        
        wUtil.click(driver.findElement(By.xpath("//input[@value='  Save  ']")));
        
      

        // Verification
        String actOrgName = wUtil.getText(driver.findElement(By.id("dtlview_Organization Name")));
        if (actOrgName.equals(organisationname)) {
            System.out.println("Organization created successfully!!!");
        } else {
            System.out.println("Organization creation failed!!!");
        }

        // Logout
        WebElement signout = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
        wUtil.hover(signout);
        wUtil.click(driver.findElement(By.linkText("Sign Out")));

        wUtil.quit();
    }
}
