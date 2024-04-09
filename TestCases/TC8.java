package TestCases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC8 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("pavani@lta.com");
		driver.findElement(By.id("password")).sendKeys("password123");
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.id("userNavLabel")).click();
		
		driver.findElement(By.xpath("//a[@title='Developer Console (New Window)']")).click();
		try {
		String parentWindow=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		for(String window:windows) {
			if (!window.equals(parentWindow)){
				driver.switchTo().window(window);
				break;
			}
		}
		Thread.sleep(3000);
		driver.close();
		System.out.println("pass:i closed the console");
		}
		catch(Exception E) {
			System.out.println("couldn't close the console");
		}
	}

}
