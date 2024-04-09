package TestCases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC37 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("pavani@lta.com");
		driver.findElement(By.id("password")).sendKeys("password123");
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.xpath("//a[@title='Home Tab']")).click();
		driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a")).click();
		
		driver.findElement(By.xpath("(//a[normalize-space()='4:00 PM'])[1]")).click();
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
        driver.findElement(By.xpath("//div[@id='timePickerItem_38']")).click();
        driver.findElement(By.xpath("//input[@id='IsRecurrence']")).click();
        Thread.sleep(3000);
       // date picker        
        driver.findElement(By.xpath("//input[@id='RecurrenceEndDateOnly']")).clear();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='RecurrenceEndDateOnly']")).click();
        Thread.sleep(3000);
        //click on end date field
        driver.findElement(By.xpath("//input[@id='RecurrenceEndDateOnly']")).click();
        //click on right arrow for nextmonth
        driver.findElement(By.xpath("//img[@alt='Next Month']")).click();
        //click on april 10th
        driver.findElement(By.xpath("//*[@id=\"calRow2\"]/td[4]")).click();
        
        //click on save
        driver.findElement(By.xpath("//input[@tabindex='14']")).click();
        driver.findElement(By.xpath("//img[@alt='Month View']")).click();
        
        //validation
        String str=driver.findElement(By.xpath("//h1[contains(text(),'Calendar for Pavani changed-1 - Month View')]")).getText();
        if (str.contains("Calendar for Pavani changed-1 - Month View"))
        	System.out.println("pass");
 
	}

}
