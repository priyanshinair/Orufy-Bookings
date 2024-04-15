package com.Bookings.Branding.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.Bookings.pageObjects.BrandingPage;

import org.testng.Assert;
import org.testng.annotations.*;

public class TC_ByDefaultValues extends BaseClassBranding{

	@BeforeMethod
	public void setup() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("https://beta.orufy.in/login?redirect=BOOKINGS");
		
		driver.findElement(By.name("emailId")).sendKeys("priyanshi+08@orufy.com");
		driver.findElement(By.name("password")).sendKeys("Orufy@123");
		
		
		
		WebElement btn = driver.findElement(By.xpath ("//*[@id=\"__next\"]/div[1]/div/form/div[3]/button"));
		
		btn.click();
		
		Thread.sleep(5000);
	}
	
	@Test
	public void defaultValues() throws InterruptedException {
		
		driver.get(brandingUrl);
		
		
		Thread.sleep(5000);
		BrandingPage var = new BrandingPage(driver);
		
		WebElement companyName = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/form/div[1]/input"));
        String defaultCompanyName = companyName.getAttribute("value");
        
        WebElement welcomeMsg = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/form/div[2]/div/textarea"));
        String defaultWelcomeMsg = welcomeMsg.getAttribute("value");
        
        WebElement accessLink = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/form/div[4]/div/input"));
        String defaultAccessLink = accessLink.getAttribute("value");
		 
        
        
        String expectedDefaultCompanyName = "bookings08";
        String expectedDefaultWelcomeMsg = "Welcome to the scheduling page! Kindly follow the instructions below to add an event to my calendar. Thank you!";
        String expectedDefaultAccessLink =   "bookings08-56566";
        
        
        
        
        Assert.assertEquals(defaultCompanyName, expectedDefaultCompanyName, "company name field does not have expected default value");
        Assert.assertEquals(defaultWelcomeMsg, expectedDefaultWelcomeMsg, "welcome msg field does not have expected default value");
        Assert.assertEquals(defaultAccessLink, expectedDefaultAccessLink, "welcome msg field does not have expected default value");
		
		
	}
}
