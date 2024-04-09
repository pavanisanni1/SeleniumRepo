package TestCases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC16 {

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
		
			
		driver.findElement(By.xpath("//a[@title='Opportunities Tab']")).click();
		driver.findElement(By.xpath("//input[@name='new']")).click();
		
		//input details for new opportunity
		driver.findElement(By.xpath("//input[@id='opp3']")).sendKeys("NewOpp1");
		
		//this popup is a window and there are two frames inside pop up window(search & results).
		//we have to first switch to new "window" then switch to "frame"
		
		driver.findElement(By.xpath("//img[@title='Account Name Lookup (New Window)']")).click();
		//switching to popup window
	String parent = driver.getWindowHandle();
	String child=driver.getWindowHandle();
	Set<String> children=driver.getWindowHandles();
	System.out.println("--------------"+children.size());
	Iterator<String> it=children.iterator();
	while(it.hasNext()) {
		child=it.next();
		
		if (!parent.equals(child)) {
			 driver.switchTo().window(child);
			System.out.println("++++++++++++++"+driver.switchTo().window(child).getTitle());
			 Thread.sleep(3000);			
		}
		 
	}
	//switching to first frame
	driver.switchTo().frame("searchFrame");
	driver.findElement(By.xpath("//input[@id='lksrch' and @placeholder='Search...']")).sendKeys("*");
	driver.findElement(By.xpath("//input[@title='Go!' and @name='go']")).click();
	
	//switch to child window
	System.out.println("window is still child window but switched from search frame. About to switch to results frame in child window"+driver.switchTo().window(child).getTitle());
	driver.switchTo().window(child);
	
	//switch to results frame
	driver.switchTo().frame("resultsFrame");
	driver.findElement(By.xpath("//*[@id=\"new\"]/div/div[3]/div/div[2]/table/tbody/tr[5]/th/a")).click();
	
	//switching back to child window from results frame and then to parent window
	
	driver.switchTo().window(parent);
		
		//driver.findElement(By.xpath("//input[@id='opp4']")).sendKeys("One-one");
		driver.findElement(By.xpath("//input[@id='opp9']")).click();
		driver.findElement(By.xpath("//a[@class='calToday']")).click();
		
		WebElement stages=driver.findElement(By.xpath("//select[@id='opp11']"));
		Select stage=new Select(stages);
		stage.selectByVisibleText("Needs Analysis");
		
		driver.findElement(By.xpath("//input[@id='opp12']")).sendKeys("");
		
		WebElement sources=driver.findElement(By.xpath("//select[@id='opp6']"));
		Select source=new Select(sources);
		source.selectByVisibleText("Partner Referral");
		
		driver.findElement(By.xpath("//input[@id='opp17']")).sendKeys("DM Campaign to Top Customers - Nov 12-23, 2001");
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Save']")).click();
        
		String str=driver.findElement(By.xpath("//h2[contains(text(),'NewOpp1')]")).getText();
        System.out.println(str);
		if (str.contains("NewOpp1"))
				System.out.println("pass");
				
				
	}

}
