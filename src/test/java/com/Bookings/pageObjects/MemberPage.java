package com.Bookings.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MemberPage {

	WebDriver ldriver;
	
	public MemberPage (WebDriver rdriver) {
		
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/button")
	@CacheLookup
	WebElement inviteBtn;
	
	@FindBy(xpath = "/html/body/div[3]/form/button")
	@CacheLookup
	WebElement saveBtn;
	
	public void clickInvite()
	{
		inviteBtn.click();
	}
	
	public void clickSave()
	{
		saveBtn.click();
	}
}
