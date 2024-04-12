package com.Bookings.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

	WebDriver ldriver;
	
	public ProfilePage(WebDriver rdriver) {
		
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(name = "firstName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(name = "lastName")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div/form/button")
	@CacheLookup
	WebElement btnSave;
	
	
	
	public void setFirstName (String fname) {
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName (String lname) {
		txtLastName.sendKeys(lname);
	}
	
	public void clickSubmit()
	{
		btnSave.click();
	}
 }
