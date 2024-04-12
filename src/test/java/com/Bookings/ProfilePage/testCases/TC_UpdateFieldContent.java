package com.Bookings.ProfilePage.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Bookings.pageObjects.ProfilePage;


import org.testng.Assert;
import org.testng.annotations.*;

public class TC_UpdateFieldContent extends BaseClassProfile{

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
		
		Thread.sleep(5000);
		
		
		ProfilePage update =new ProfilePage(driver);
		
		WebElement firstName = driver.findElement(By.name("firstName"));
        String defaultFirstName = firstName.getAttribute("value");
        
        WebElement lastName = driver.findElement(By.name("lastName"));
        String defaultLastName = lastName.getAttribute("value");
        
        firstName.clear();
        lastName.clear();
		
		update.setFirstName("Priyanshi1");
		update.setLastName("Nair1");
		
		update.clickSubmit();
		
		driver.get("https://bookings.beta.orufy.in/account-settings/general-settings");
		
		Thread.sleep(3000);
		
		driver.get(profileUrl);
		
		Thread.sleep(3000);
		
	
		 
        String expectedDefaultFirstName = "Priyanshi1";
        String expectedDefaultLastName = "Nair1";
        
        Assert.assertEquals(defaultFirstName, expectedDefaultFirstName, "First name field does not have expected default value");
        Assert.assertEquals(defaultLastName, expectedDefaultLastName, "First name field does not have expected default value");
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
