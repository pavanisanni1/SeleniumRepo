package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC13 {

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
		
		driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]")).click();
		
		driver.findElement(By.xpath("//input[@id='srch']")).sendKeys("on");		
		driver.findElement(By.xpath("//div[@class='pbWizardBody']//input[2]")).click();
				
		if (!driver.findElement(By.xpath("//input[@id='cid0']")).isSelected())
			driver.findElement(By.xpath("//input[@id='cid0']")).click();
		if (!driver.findElement(By.xpath("//input[@id='cid1']")).isSelected())
			driver.findElement(By.xpath("//input[@id='cid1']")).click();
		
		driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@title='Next']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='pbTopButtons']//input[@title='Merge']")).click();
		driver.switchTo().alert().accept();
		
		WebElement views=driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
		Select view=new Select(views);
		view.selectByVisibleText("Recently Viewed");
		
		WebElement viewDisplay=driver.findElement(By.xpath("//a[contains(text(),'One-one')]"));
		String str=viewDisplay.getText();
		System.out.println(str);
		if(str.equals("One-one"))
			System.out.println("pass");
	}

}
