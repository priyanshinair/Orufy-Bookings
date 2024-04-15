package com.Bookings.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

    // Constructor
    public LoginPage(WebDriver rdriver) {
    	
        ldriver = rdriver;
        
        PageFactory.initElements(rdriver, this);
        
		
	}
	
	@FindBy(name = "emailId")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div/form/div[3]/button")
	@CacheLookup
	WebElement btnLogin;
	
	
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		btnLogin.click();
	}
	
}
