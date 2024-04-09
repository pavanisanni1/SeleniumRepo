package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC4 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		Thread.sleep(3000);
		driver.findElement(By.id("forgot_password_link")).click();
		
		driver.findElement(By.xpath("//input[@id='un']")).sendKeys("pavani@lta.com");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//*[@id=\"forgotPassForm\"]/div/p[1]")).getText());
		System.out.println("pass");	
		
	}

}
