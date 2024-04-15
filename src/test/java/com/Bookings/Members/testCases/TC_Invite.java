package com.Bookings.Members.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.Bookings.pageObjects.MemberPage;

public class TC_Invite extends BaseClassMembers{
	
	
	@BeforeMethod
	public void setup() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("https://beta.orufy.in/login?redirect=BOOKINGS");
		
		driver.findElement(By.name("emailId")).sendKeys("priyanshi@orufy.com");
		driver.findElement(By.name("password")).sendKeys("Orufy@123");
		
		
		
		WebElement btn = driver.findElement(By.xpath ("//*[@id=\"__next\"]/div[1]/div/form/div[3]/button"));
		
		btn.click();
		
		Thread.sleep(5000);
	}
	
	@Test
	public void invite () throws InterruptedException {
		
		driver.get(memberUrl);
		
		Thread.sleep(5000);
		
		MemberPage invite = new MemberPage(driver);
		
		invite.clickInvite();
		
		Thread.sleep(5000);
		
		WebElement email = driver.findElement(By.xpath("/html/body/div[3]/form/div/div[1]/input"));
		
		WebElement role = driver.findElement(By.xpath("/html/body/div[3]/form/div/div[2]/select"));
		
		
		email.sendKeys("priyanshi+01@orufy.com");
		
	
		
		
		//Thread.sleep(5000);
		
		
		
		Select dropdown = new Select(role);
		
		//Thread.sleep(2000);
		
		dropdown.selectByVisibleText("Agent");
		
		
		Thread.sleep(5000);
		
		
		//role.click();
	
		
		
		
		Thread.sleep(5000);
		
		invite.clickSave();
		
	}
	//
}
