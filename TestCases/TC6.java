package TestCases;
//incomplete since pop is not reachable

import java.util.Set;
//edit user info
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC6 {

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
		
		//parent window
		driver.findElement(By.xpath("//img[@title='Edit Profile']")).click();
		Thread.sleep(3000);
		
		//popup is opened and find the number of frames	but i dont know how to find the right frame. i just tried frames1 0,1,2 and 2 worked.
	
		int size = driver.findElements(By.tagName("iframe")).size();
				System.out.println("number of frames:" +size);
				
				
				driver.switchTo().frame(2);
				Thread.sleep(4000);
				
				 driver.findElement(By.id("aboutTab")).click();
					Thread.sleep(4000);
					 driver.findElement(By.id("lastName")).clear();	
				 driver.findElement(By.id("lastName")).sendKeys("changed");
				
				 driver.findElement(By.xpath("//input[@value='Save All']")).click();
				 
				 //switch back to original
				 driver.switchTo().defaultContent();
					System.out.print(driver.findElement(By.id("tailBreadcrumbNode")).getText());
					System.out.println("pass");

	}

}
