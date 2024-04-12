package com.Bookings.ProfilePage.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.Bookings.pageObjects.LoginPage;
import com.Bookings.pageObjects.ProfilePage;

public class TC_DefaultFieldContent extends BaseClassProfile{

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
		// Add conditional check here

	}
	@Test
	public void fieldValue () throws InterruptedException {
		
		driver.get(profileUrl);
		//logger.info("url is opened");
		
		ProfilePage pp = new ProfilePage(driver);
		
		/*
        String expectedFirstName = "Priyanshi";
        pp.setFirstName(expectedFirstName);
        
        String expectedLastName = "Priyanshi";
        pp.setLastName(expectedLastName);
        */
		
		Thread.sleep(5000);
		
		
		WebElement firstName = driver.findElement(By.name("firstName"));
        String defaultFirstName = firstName.getAttribute("value");
        
        WebElement lastName = driver.findElement(By.name("lastName"));
        String defaultLastName = lastName.getAttribute("value");
		 
        String expectedDefaultFirstName = "Priyanshi";
        String expectedDefaultLastName = "Nair";
        
        Assert.assertEquals(defaultFirstName, expectedDefaultFirstName, "First name field does not have expected default value");
        Assert.assertEquals(defaultLastName, expectedDefaultLastName, "First name field does not have expected default value");

	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}

