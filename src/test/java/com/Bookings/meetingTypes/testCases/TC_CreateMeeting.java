package com.Bookings.meetingTypes.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import com.Bookings.pageObjects.MeetingTypes;

public class TC_CreateMeeting extends BaseClassMeetingType{
	
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
	public void create() throws InterruptedException {
		
		driver.get(meetingUrl);
		
		Thread.sleep(5000);
		
		MeetingTypes meeting = new MeetingTypes(driver);
		
		meeting.create();
		
		Thread.sleep(5000);
		
		WebElement name = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/input"));
		Thread.sleep(5000);
		name.sendKeys("Round-Robin");
		
		/*
		WebElement duration = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input"));
		Thread.sleep(5000);
		duration.sendKeys("30");
		*/
		WebElement mode = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/select"));
		Thread.sleep(5000);
		Select dropdown1 = new Select(mode);
		dropdown1.selectByVisibleText("Google meet");
		
		/*
		WebElement type = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/select"));
		Thread.sleep(5000);
		Select dropdown2 = new Select(type);
		dropdown2.selectByVisibleText("One-on-one (one host with one attendee)");
		*/
		Thread.sleep(5000);
		
		meeting.save();
		
		
		
		
		
	}

}
