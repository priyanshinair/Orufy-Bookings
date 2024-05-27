package com.Bookings.meetingTypes.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.* ;

public class TC_DeleteMeetingType extends BaseClassMeetingType{
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("https://beta.orufy.in/login?redirect=BOOKINGS");
		
		driver.findElement(By.name("emailId")).sendKeys("priyanshi+006@orufy.com");
		driver.findElement(By.name("password")).sendKeys("Orufy@123");
		
		WebElement btn = driver.findElement(By.xpath ("//*[@id=\"__next\"]/div[1]/div/form/div[3]/button"));
		
		btn.click();
		
		Thread.sleep(5000);
	}
	
	@Test
	public void delete () throws InterruptedException {
		
		driver.get(meetingUrl);
		
		Thread.sleep(5000);
		
		WebElement dot = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[3]/div[2]/button[2]"));
		Thread.sleep(3000);
		dot.click();
		
		Thread.sleep(3000);
		
		WebElement select = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]"));
		select.click();
		
		Thread.sleep(3000);
		
		WebElement deleteBtn = driver.findElement(By.xpath("/html/body/div[3]/div[2]/button[2]"));
		deleteBtn.click();
		
	}
}
