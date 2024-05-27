package com.Bookings.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MeetingTypes {

	WebDriver ldriver;
	
	public MeetingTypes(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath = "/html/body/div[3]/div[2]/form/div[1]/input")
	@CacheLookup
	WebElement meetingName;
	
	@FindBy(xpath = "/html/body/div[3]/form/div[2]/input")
	@CacheLookup
	WebElement duration;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/button")
	@CacheLookup
	WebElement btnCreate;
	
	@FindBy(xpath = "/html/body/div[3]/div[2]/form/div[7]/button")
	@CacheLookup
	WebElement btnSave;
	
	
	public void setMeetingName(String meetName) {
		
		meetingName.sendKeys(meetName);
	}
	
	public void setDuration(String dura) {
		duration.sendKeys(dura);
	}
	
	public void create() {
		btnCreate.click();
	}
	
	public void save() {
		btnSave.click();
	}
}
