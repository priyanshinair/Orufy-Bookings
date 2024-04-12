package com.Bookings.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver ldriver;
	
	public void Register(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div[1]/p/a")
	@CacheLookup
	WebElement lnkRegister;
	
	@FindBy(how = How.NAME, using = "firstName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(how = How.NAME, using = "lastName")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(how = How.NAME, using = "email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how = How.NAME, using = "phoneNo")
	@CacheLookup
	WebElement txtPhone;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div[1]/div/form/button")
	@CacheLookup
	WebElement btnRegister;
	
	
	public void clickRegister() {
		lnkRegister.click();
	}
	
	public void firstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	
	public void lastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	
	public void password(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void email(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void phoneNo(String phone) {
		txtPhone.sendKeys(phone);
	}
	
	public void register() {
		btnRegister.click();
	}
}
