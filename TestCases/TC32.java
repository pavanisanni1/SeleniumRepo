package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC32 {

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
		
		driver.findElement(By.xpath("//input[@title='New']")).click();
        driver.findElement(By.xpath("//input[@id='name_lastcon2']")).sendKeys("Indian-3");
        driver.findElement(By.xpath("//input[@id='con4']")).sendKeys("One-one");
        driver.findElement(By.xpath("(//input[@title='Save & New'])[1]")).click();
        
        //validation
        String header=driver.findElement(By.xpath("//h1[@class='pageType']")).getText();
     
        driver.findElement(By.xpath("(//a[normalize-space()='Contacts'])[1]")).click();	
        String newContact= driver.findElement(By.xpath("(//a[contains(text(),'Indian-3')])[1]")).getText();
        
      
       System.out.println(newContact+" "+header);
        if(newContact.contains("Indian-3") && (header.contains("Contact Edit")))
        		System.out.println("new contact created:pass");
	}

}
