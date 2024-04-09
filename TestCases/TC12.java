package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC12 {

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
			
			driver.findElement(By.xpath("//a[@title='Accounts Tab']")).click();
			
			 WebElement viewOptions=driver.findElement(By.xpath("//select[@id='fcf']"));			
		        Select view=new Select(viewOptions);
		        view.selectByVisibleText("Recently Added New View1");
		        
		        driver.findElement(By.xpath("//a[normalize-space()='Edit']")).click();		     
		        driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("Changed2 Recently Added New View1");
		        
		        WebElement fields=driver.findElement(By.xpath("//select[@id='fcol1']"));
		        Select field=new Select(fields);
		       field.selectByVisibleText("Account Name");
		       
		       WebElement operators=driver.findElement(By.xpath("//select[@id='fop1']"));
		       Select operator=new Select(operators);
		       operator.selectByVisibleText("contains");
		      		       
		       driver.findElement(By.xpath("//input[@id='fval1']")).sendKeys("a");		      
		       
		       driver.findElement(By.xpath("//option[@value='SOCIAL_PERSONA_FACEBOOK']")).click();
		       driver.findElement(By.xpath("//a[@id='colselector_select_0_right']//img[@title='Add']")).click();
		    
		       driver.findElement(By.xpath("//input[@data-uidsfdc='5']")).click();
		       
		       
		       // System.out.println(driver.findElement(By.xpath("//select[@id='00Bbm000000pbFF_listSelect']")).getText());
		     WebElement checks=driver.findElement(By.xpath("//select[@id='00Bbm000000pbFF_listSelect']"));
		     Select check=new Select(checks);
		     System.out.println(check.getFirstSelectedOption().getText());
		     System.out.println("pass");
		       
	}

}
