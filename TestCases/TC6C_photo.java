package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC6C_photo {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("pavani@lta.com");
		driver.findElement(By.id("password")).sendKeys("password123");
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.id("userNavLabel")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='My Profile']")).click();
		Thread.sleep(3000);
		
		
		WebElement photoHover=driver.findElement(By.id("photoSection"));
		Actions actions=new Actions(driver);
		actions.moveToElement(photoHover);
		WebElement uploadLink=driver.findElement(By.id("uploadLink"));
		actions.moveToElement(uploadLink);
        actions.click().build().perform();
       
        //upload popup frame
        WebElement iframe=driver.findElement(By.id("uploadPhotoContentId"));
        driver.switchTo().frame(iframe);
        WebElement photoChoose=driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadInputFile'][1]"));
        photoChoose.sendKeys("C:/flower.jpg");
        Thread.sleep(4000);
        driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn")).click();        
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@class=\"btn saveButton\"]")).click();
        
       
	}

}

