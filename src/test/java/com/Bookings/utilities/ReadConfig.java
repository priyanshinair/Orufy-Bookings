package com.Bookings.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	
	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./configurations/BookingsConfig.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch(Exception e) {
			System.out.println("exception is"+e.getMessage());
		}
	}
	
	public String getApplicationUrl()
	{
		String url = pro.getProperty("baseUrl");
		return url;
	}
	
	public String getEmail()
	{
		String email = pro.getProperty("email");
		return email;
	}
	
	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getChromepath()
	{
		String chromePath = pro.getProperty("chromePath");
		return chromePath;
	}
	
	public String getProfileurl()
	{
		String profileUrl = pro.getProperty("profileUrl");
		return profileUrl;
	}
	
	public String getMemberurl()
	{
		String memberUrl = pro.getProperty("memberUrl");
		return memberUrl;
	}
	
	public String getBrandingurl()
	{
		String brandingUrl = pro.getProperty("brandingUrl");
		return brandingUrl;
	}
	
	public String getMeetingTypeurl()
	{
		String meetingUrl = pro.getProperty("meetingTypeUrl");
		return meetingUrl;
	}
	
	public String getHolidaysUrl()
	{
		String holidaysUrl = pro.getProperty("holidaysUrl");
		return holidaysUrl;
	}
}
