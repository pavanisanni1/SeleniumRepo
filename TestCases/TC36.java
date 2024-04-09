package TestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC36 {

	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("pavani@lta.com");
		driver.findElement(By.id("password")).sendKeys("password123");
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.xpath("//a[@title='Home Tab']")).click();
		driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a")).click();
		
		driver.findElement(By.xpath("(//a[normalize-space()='8:00 PM'])[1]")).click();
		driver.findElement(By.xpath("(//img[@title='Subject Combo (New Window)'])[1]")).click();
		
		String parentWindow=driver.getWindowHandle();
		String subWindow=null;
		
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it= handles.iterator();
		while(it.hasNext()) {
			subWindow=it.next();
		}
		driver.switchTo().window(subWindow);//switching to sub window
		driver.findElement(By.xpath("//a[contains(text(),'Other')]")).click();
		driver.switchTo().window(parentWindow);//switch back to parent window
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='EndDateTime_time']")).click();		
        driver.findElement(By.xpath("//div[@id='timePickerItem_42']")).click();
        driver.findElement(By.xpath("//input[@tabindex='14']")).click();
        
        //validation
        String str=driver.findElement(By.xpath("//h1[contains(text(),'Calendar for Pavani changed-1 - Day View')]")).getText();
        if(str.contains("Calendar for Pavani changed-1 - Day View"))
        {
        	driver.findElement(By.xpath("//*[@id=\"p:f:j_id25:j_id69:28:j_id71:0:j_id72:calendarEvent:j_id84\"]/a/span")).click();
        	String startTime=driver.findElement(By.xpath("//div[contains(text(),'8:00 PM')]")).getText();
        	String endTime=driver.findElement(By.xpath("//div[contains(text(),'9:00 PM')]")).getText();
        	System.out.println(startTime+"  "+endTime);  
        	if(startTime.contains("8:00 PM")&& (endTime.contains("9:00 PM")))
        	System.out.println("pass");
        }
        
	}

}
