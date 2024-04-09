package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC4B {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("123");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("22131");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println(driver.findElement(By.id("error")).getText());
		System.out.println("pass");
		

	}

}
