package TestCases;
//"error message 'Please enter your password.' should be displayed"

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;//this is for driver=new chromeDriver()
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		
		driver.findElement(By.id("username")).sendKeys("pavani@lta.com");
		//driver.findElement(By.id("password")).sendKeys("chittiSanni12");
		driver.findElement(By.id("Login")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='error']")).getText());
		System.out.println("pass");
		//driver.close();
	}

}
