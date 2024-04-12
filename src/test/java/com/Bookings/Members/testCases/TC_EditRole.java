package com.Bookings.Members.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

public class TC_EditRole extends BaseClassMembers{

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
	public void editRole () throws InterruptedException {
		
		
		driver.get(memberUrl);
		
		Thread.sleep(5000);
		
		
		WebElement row = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/table/tbody/tr[2]"));
		
		WebElement menu = row.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/table/tbody/tr[2]/td[4]/button"));
		
		menu.click();
		
		Thread.sleep(5000);
		
		WebElement edit = driver.findElement(By.xpath("/html/body/div[4]/div/div[1]"));
		
		edit.click();
	}
}
