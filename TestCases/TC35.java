package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC35 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("pavani@lta.com");
		driver.findElement(By.id("password")).sendKeys("password123");
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.xpath("//img[@title='All Tabs']")).click();
        driver.findElement(By.xpath("//input[@value='Customize My Tabs']")).click();
                
        WebElement tabs=driver.findElement(By.id("duel_select_1"));
        Select tab=new Select(tabs);
        tab.selectByVisibleText("Libraries");
        driver.findElement(By.xpath("//img[@title='Remove']")).click();
        driver.findElement(By.xpath("//input[@name='save']")).click();
        
        //validate
       String str= driver.findElement(By.id("tabBar")).getText();
       if (!str.contains("Libraries"))
        System.out.println(str+" doesnt have Libraries: pass");
        
	}

}
