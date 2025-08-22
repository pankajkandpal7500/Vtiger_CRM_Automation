package VtigerCRM;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTC001 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		Thread.sleep(1000);
		//pankaj
		
		WebElement username=driver.findElement(By.xpath("//input[@name=\"user_name\"]"));
		username.sendKeys("admin");
		
		WebElement password=driver.findElement(By.xpath("//input[@name=\"user_password\"]"));
		password.sendKeys("manager");
		
		WebElement login=driver.findElement(By.id("submitButton"));
		login.click();
		
		
		
		//click the organization button 
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/table/tbody/tr/td[6]/a")).click();
		
		
		driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a/img")).click();
		
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys("QSPIDER");
		
		driver.findElement(By.xpath("//input[@class=\"crmbutton small save\"]")).click();
		
		Thread.sleep(3000);
		
		
		driver.quit();

	}

}
