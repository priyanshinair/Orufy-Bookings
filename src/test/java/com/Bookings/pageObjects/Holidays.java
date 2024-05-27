package com.Bookings.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Holidays {

	WebDriver ldriver;
	
	public void holiday(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div/div/button")
	@CacheLookup
	WebElement create;
	
	public void createBtn() {
		create.click();
	}
}
