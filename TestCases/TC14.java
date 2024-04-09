package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC14 {

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
		
		//click on reports>30 days		
		driver.findElement(By.xpath("//a[normalize-space()='Accounts with last activity > 30 days']")).click();
		
		//click on datefield
		driver.findElement(By.xpath("//img[@id='ext-gen148']")).click();		
		//select created date
		driver.findElement(By.xpath("//div[contains(text(),'Created Date')]")).click();
		
        //click on date picker
		driver.findElement(By.xpath("//img[@id='ext-gen152']")).click();
        //select today's date		
		driver.findElement(By.xpath("//button[@id='ext-gen281']")).click();
		
		
       //click on date picker-not locating so sending value.			
		driver.findElement(By.xpath("//input[@name='endDate']")).clear();
		driver.findElement(By.xpath("//img[@id='ext-gen154']")).click();
		driver.findElement(By.xpath("//input[@name='endDate']")).sendKeys("03/23/2024");
		driver.findElement(By.xpath("//button[@id='ext-gen61']")).click();
		driver.findElement(By.xpath("//img[@id='ext-gen154']")).click();
		
		
		driver.findElement(By.xpath("//button[@id='ext-gen49']")).click();//click save
		
		driver.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']")).sendKeys("Report7");
		driver.findElement(By.xpath("//input[@name='reportDevName']")).sendKeys("Report7");
		Thread.sleep(3000);//save and run
		driver.findElement(By.xpath("//button[contains(text(),'Save and Run Report')]")).click();
		Thread.sleep(3000);
		//validation
		String str=driver.findElement(By.xpath("//h1[contains(text(),'Report7')]")).getText();		
		System.out.println(str);
		if (str.contains("Report7")) System.out.println("pass");
	}

}
