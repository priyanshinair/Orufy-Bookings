package com.Bookings.meetingTypes.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.Bookings.utilities.ReadConfig;

public class BaseClassMeetingType {

	ReadConfig readconfig = new ReadConfig();
	
	String meetingUrl = readconfig.getMeetingTypeurl();
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	@BeforeClass
	
	public void setup() throws InterruptedException {
		
		driver = new ChromeDriver();
		
		logger = Logger.getLogger("orufy bookings");
		
		PropertyConfigurator.configure("log4j.properties");
		
		
	}
	
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
}

