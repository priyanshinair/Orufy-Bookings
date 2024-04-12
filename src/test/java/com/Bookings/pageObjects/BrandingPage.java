package com.Bookings.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrandingPage {

	WebDriver ldriver;
	
	public BrandingPage (WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/form/div[1]/input")
	@CacheLookup
	WebElement companyName;
	
	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/form/div[2]/div/textarea")
	@CacheLookup
	WebElement welcomeMsg;
	
	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/form/div[4]/div/input")
	@CacheLookup
	WebElement accessLink;
	
	
	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/form/button")
	@CacheLookup
	WebElement btnSave;
	
	public void setCompanyName (String company) {
		companyName.sendKeys(company);
	}
	
	public void setWelcomeMsg (String welcome) {
		welcomeMsg.sendKeys(welcome);
	}
	
	public void setAccessLink (String access) {
		accessLink.sendKeys(access);
	}
	
	public void save () {
		btnSave.click();
	}
}
