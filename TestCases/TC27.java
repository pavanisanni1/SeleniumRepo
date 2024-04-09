package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC27 {

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
		
		//click on contacts
		driver.findElement(By.xpath("//a[@title='Contacts Tab']")).click();
		
		WebElement createdContacts=driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
		Select contact=new Select(createdContacts);
		String str=contact.getFirstSelectedOption().getText();
		System.out.println(str);
		if(str.contains("Recently Created"))
			System.out.println("pass");

	}

}
