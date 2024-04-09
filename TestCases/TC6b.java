package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC6b {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("pavani@lta.com");
		driver.findElement(By.id("password")).sendKeys("password123");
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.id("userNavLabel")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='My Profile']")).click();
		Thread.sleep(3000);
		
         //click on file link
		driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext') and text()='File']")).click();
		Thread.sleep(3000);
		//click on upload button
	    driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']")).click();
		Thread.sleep(3000);
		
		//click on choose button
		driver.findElement(By.xpath("//input[@id='chatterFile']")).sendKeys("C:/test1.txt");
		driver.findElement(By.id("publishersharebutton")).click(); Thread.sleep(3000);
		
		//checking the content on the home tab in recent items
		driver.findElement(By.xpath("//*[@id=\"home_Tab\"]/a")).click();
		Thread.sleep(3000);
		
		if(driver.findElement(By.xpath("//*[@id=\"mru069bm000000Ix49\"]/a/img")).getAttribute("alt").contains("test1"))
			System.out.println("pass");
		
		
		
		
	}

}
