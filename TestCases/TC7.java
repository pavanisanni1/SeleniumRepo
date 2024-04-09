package TestCases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC7 {

	public static void main(String[] args) throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("pavani@lta.com");
		driver.findElement(By.id("password")).sendKeys("password123");
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.id("userNavLabel")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='My Settings']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("PersonalInfo_font")).click();
		Thread.sleep(3000);				
		driver.findElement(By.xpath("//span[contains(text(),'Login History')]")).click();
		
		driver.findElement(By.id("DisplayAndLayout_font")).click();
		driver.findElement(By.xpath("//span[@id='CustomizeTabs_font' and contains(text(),'Customize My Tabs')]")).click();
		Select customApp=new Select(driver.findElement(By.xpath("//select[@name='p4']")));
		customApp.selectByVisibleText("Salesforce Chatter");
		Select availableTabs=new Select(driver.findElement(By.xpath("//select[@name='duel_select_0' and @id='duel_select_0']")));
		availableTabs.selectByVisibleText("Reports");
		driver.findElement(By.xpath("//img[@alt='Add']")).click();
		
		driver.findElement(By.id("EmailSetup_font")).click();
		driver.findElement(By.id("EmailSettings_font")).click();
		driver.findElement(By.xpath("//input[@id='sender_name' and @name='sender_name']")).clear();
		driver.findElement(By.xpath("//input[@id='sender_name' and @name='sender_name']")).sendKeys("pavani_changed1");
		driver.findElement(By.xpath("//input[@id='sender_email' and @name='sender_email']")).clear();
		driver.findElement(By.xpath("//input[@id='sender_email' and @name='sender_email']")).sendKeys("pavanisanni@yahoo.com");		
		driver.findElement(By.xpath("//input[@id='auto_bcc1']")).click();
		driver.findElement(By.xpath("//input[@type='submit' and @name='save']")).click();		
		
		
		driver.findElement(By.id("CalendarAndReminders_font")).click();
		driver.findElement(By.xpath("//span[@class='leafText' and contains(text(),'Activity Reminders')]")).click();
		driver.findElement(By.id("testbtn")).click();
		Thread.sleep(3000);
		
		String parentWindow=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		
		for(String window:windows) {
			if (!window.equals(parentWindow)){
				driver.switchTo().window(window);
				break;
			}
		}
		WebElement element=driver.findElement(By.xpath("//div[contains(text(),'Sample Event')]"));
		System.out.println(element.getText());
		if (element.getText().contains("Sample Event"))
		System.out.println("pass");		

	}

}
