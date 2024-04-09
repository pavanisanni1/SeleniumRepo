package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC22 {
	static WebDriver driver;
	public static void login() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
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
	}

	public static void main(String[] args) {
		login();
		driver.findElement(By.xpath("//a[normalize-space()='Leads']")).click();
		
		WebElement views=driver.findElement(By.xpath("//select[@id='fcf']"));
		Select view=new Select(views);
		view.selectByVisibleText("My Unread Leads");				
		//driver.findElement(By.xpath("//input[@title='Go!']")).click();
		//logout
		driver.findElement(By.id("userNavLabel")).click();
        driver.findElement(By.xpath("//a[@title='Logout']")).click();
        driver.close();
        
        //login
        login();
        driver.findElement(By.xpath("//a[normalize-space()='Leads']")).click();
        //go button
        driver.findElement(By.xpath("//input[@title='Go!']")).click();
        
        WebElement viewsCheck=driver.findElement(By.xpath("//select[@name='fcf']"));
		Select viewCheck=new Select(viewsCheck);
        String str=viewCheck.getFirstSelectedOption().getText();
        
        System.out.println(str);
        System.out.println("pass");
	}

}
