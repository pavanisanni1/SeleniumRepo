package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		
		//login
		driver.findElement(By.id("username")).sendKeys("pavani@lta.com");
		driver.findElement(By.id("password")).sendKeys("password123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='r4 fl mr8']")).click();		
		driver.findElement(By.id("Login")).click();
		//driver.close();	
		
		//logout and user name is saved.
         driver.findElement(By.id("userNavLabel")).click();
         Thread.sleep(3000);
         driver.findElement(By.xpath("//a[@title='Logout']")).click();
         Thread.sleep(3000);
         System.out.println(driver.findElement(By.id("username")).getAttribute("value"));
         System.out.println("pass");
       
	}

}
