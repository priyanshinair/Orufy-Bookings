package com.Bookings.meetingTypes.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TC_MeetingDisabled extends BaseClassMeetingType{

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
	public void disable() throws InterruptedException {
		
		driver.get(meetingUrl);
		
		Thread.sleep(3000);
		
		WebElement toggle = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/button"));
		Thread.sleep(3000);
		
		if(toggle.isSelected()) {
			toggle.click();
		}
		else {
			System.out.println("toggle is off");
		}
		
		Thread.sleep(3000);
		
		WebElement shareBtn = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[3]/div[2]/button[1]"));
		Thread.sleep(3000);
		
		boolean isDisabled = !shareBtn.isEnabled() || shareBtn.getAttribute("disabled")!= null;
		
		if(isDisabled) {
			System.out.println("disabled");
		}
		else {
			System.out.println("enabled");
		}
	}
	
}
