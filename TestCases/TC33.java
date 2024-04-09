package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC33 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("pavani@lta.com");
		driver.findElement(By.id("password")).sendKeys("password123");
		driver.findElement(By.id("Login")).click();
	    
		//check if it is the correct user with title of the page and login profile name.
		WebElement element=driver.findElement(By.id("userNavLabel"));
		String name=element.getText();
		System.out.println("name on website:"+name);
		  element.click();
			
		  driver.findElement(By.xpath("//a[@title='My Profile']")).click();
		String title=driver.getTitle();		
		System.out.println(title);
		
		if( title.contains(name))
			System.out.println("correct user");
			else System.out.println("wrong user");	
		
		driver.findElement(By.id("userNavLabel")).click();
		driver.findElement(By.xpath("//a[@title='My Profile']")).click();	
		String profileName=driver.findElement(By.xpath("//span[@id='tailBreadcrumbNode']")).getText();
		System.out.println("profile name from 'My Profile': "+profileName);
		
		
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		
		WebElement userName=driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[1]/h1/a"));
		String user=userName.getText();
		System.out.println(user+" user from Home page");
		userName.click();
			
		if (profileName.contains(user))
		System.out.println("same page from home and profile:pass");
		

	}

}
