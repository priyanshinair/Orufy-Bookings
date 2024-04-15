package com.Bookings.ProfilePage.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.Bookings.pageObjects.ProfilePage;

public class TC_UploadOtherFormat extends BaseClassProfile{

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setup () throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("https://beta.orufy.in/login?redirect=BOOKINGS");
		
		driver.findElement(By.name("emailId")).sendKeys("priyanshi@orufy.com");
		driver.findElement(By.name("password")).sendKeys("Orufy@123");
		
		
		
		WebElement btn = driver.findElement(By.xpath ("//*[@id=\"__next\"]/div[1]/div/form/div[3]/button"));
		
		btn.click();
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000); // Sleep for 5 seconds
		
	}
	
	@Test
public void fieldValue () throws InterruptedException {
		
		ProfilePage update =new ProfilePage(driver);
		
		driver.get(profileUrl);
		
		Thread.sleep(5000);
		
		WebElement picture = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/button"));
		
		String imagePath = getClass().getResource("pexels-emma-llamas-10208097.jpg").getPath();
		picture.sendKeys(imagePath);
		
		update.clickSubmit();
		
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
}
