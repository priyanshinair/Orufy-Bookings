package com.Bookings.ProfilePage.testCases;

import org.testng.Assert;
import org.testng.annotations.* ;

import com.Bookings.pageObjects.LoginPage;

public class TC_Login extends BaseClass{

	@Test
	public void loginTest()
	{
		driver.get(baseUrl);
		logger.info("url is opened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setEmail(email);
		logger.info("entered email");
		
		lp.setPassword(password);
		logger.info("entered password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Orufy"))
		{
			Assert.assertTrue(true);
			logger.info("test passed");
		}
		else {
			Assert.assertFalse(false);
			logger.info("test failed");
		}
	}
}
