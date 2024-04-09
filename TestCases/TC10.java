package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TC10 {

	public static void main(String[] args) throws InterruptedException {
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
		
		driver.findElement(By.xpath("//a[@title='Accounts Tab']")).click();
        driver.findElement(By.xpath("//input[@name='new']")).click();
		driver.findElement(By.id("acc2")).sendKeys("TestingAccount");
		
		WebElement type=driver.findElement(By.id("acc6"));
		Select techType=new Select(type);
		techType.selectByVisibleText("Technology Partner");
		
		WebElement customPr=driver.findElement(By.id("00Nbm00000055qI"));
		Select priority=new Select(customPr);
		priority.selectByVisibleText("High");
		
		driver.findElement(By.xpath("//input[@tabindex='34']")).click();
		String accountName=driver.findElement(By.xpath("//h2[@class='topName']")).getText();
		//System.out.println(driver.findElement(By.xpath("//h2[@class='topName']")).getText());
		if (accountName.equals("TestingAccount"))
			System.out.println("pass");
			else System.out.println("fail");		
		
	}

}
