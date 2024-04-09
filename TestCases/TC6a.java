package TestCases;
//post
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC6a {

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
		
		//click on post link
		driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext') and text()='Post']")).click();
		
		//int size = driver.findElements(By.tagName("iframe")).size();
		//System.out.println(size);
		
		//switch to frame type and share
		driver.switchTo().frame(0);
		Thread.sleep(4000);		
		
		driver.findElement(By.xpath("//body[@spellcheck='true']")).sendKeys("it is a check for input text");
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='publishersharebutton']")).click();
        System.out.println("pass");
	}

}
