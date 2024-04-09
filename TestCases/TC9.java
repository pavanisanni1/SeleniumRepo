package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC9 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("pavani@lta.com");
		driver.findElement(By.id("password")).sendKeys("password123");
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.id("userNavLabel")).click();
		driver.findElement(By.xpath("//a[@title='Logout']")).click();
       System.out.println(driver.getCurrentUrl());
       String str=driver.getCurrentUrl();
       if (str.contains("logout"))
	   System.out.println("pass:loggedout");
	}
}
