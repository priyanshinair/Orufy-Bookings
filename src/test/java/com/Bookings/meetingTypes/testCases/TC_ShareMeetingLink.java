package com.Bookings.meetingTypes.testCases;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TC_ShareMeetingLink extends BaseClassMeetingType{

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
	public void share() throws InterruptedException, UnsupportedFlavorException, IOException {
		
		driver.get(meetingUrl);
		
		Thread.sleep(5000);
		
		WebElement shareBtn = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[3]/div[2]/button[1]"));
		Thread.sleep(5000);
		shareBtn.click();
		
		WebElement copyLink = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div/div/button"));
		Thread.sleep(5000);
		copyLink.click();
		
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		String copiedLink = (String)clipboard.getData(DataFlavor.stringFlavor);
		
		//open new tab
		((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
		
		//switch to new tab
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		//paste copied link
		driver.get(copiedLink);
		
	}
}
