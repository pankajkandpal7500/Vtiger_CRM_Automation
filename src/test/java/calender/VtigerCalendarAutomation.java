package calender;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VtigerCalendarAutomation {

    public static void main(String[] args) throws InterruptedException {
        
        // Set path of ChromeDriver if not in system PATH
        // Example: System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        
        driver.get("http://localhost:8888/");
		WebElement username = driver.findElement(By.xpath("//input[@name=\"user_name\"]"));
		username.sendKeys("admin");

		WebElement password = driver.findElement(By.xpath("//input[@name=\"user_password\"]"));
		password.sendKeys("manager");

		WebElement login = driver.findElement(By.id("submitButton"));
		login.click();

		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/table/tbody/tr/td[2]/a")).click();
        
        
        Thread.sleep(3000); 
        
        // Step 4: Verify calendar page is displayed
        String title = driver.getTitle();
        if(title.contains("Calendar")) {
            System.out.println("✅ Calendar module opened successfully!");
        } else {
            System.out.println("❌ Failed to open Calendar module.");
        }
        
        // Step 5: Example - Click on "Day View" (if available)
        try {
            WebElement dayView = driver.findElement(By.xpath("//a[text()='Day']"));
            dayView.click();
            System.out.println("📅 Switched to Day View.");
        } catch (Exception e) {
            System.out.println("⚠️ Day view not found.");
        }
        
        // Step 6: Close browser
        Thread.sleep(2000);
        driver.quit();
    }
}

