package com.Bookings.ProfilePage.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.Bookings.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	
	public String baseUrl = readconfig.getApplicationUrl();
	public String email = readconfig.getEmail();
	public String password = readconfig.getPassword();
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	
	@BeforeClass
	public void setup ()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		logger = Logger.getLogger("orufyweb");
		
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
