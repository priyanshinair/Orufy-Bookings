package com.Bookings.Branding.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.Bookings.utilities.ReadConfig;

public class BaseClassBranding {

	
	ReadConfig readconfig = new ReadConfig();
	
	String brandingUrl = readconfig.getBrandingurl();
	
	public static WebDriver driver;
	
	public static Logger logger;
	

	@BeforeClass
	public void setup() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		logger = Logger.getLogger("orufy bookings");
		
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
}
