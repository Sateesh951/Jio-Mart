package com.QOBOX.web.bdd.screens;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Pcloudy {
	
	WebDriver driver ;
//	DesiredCapabilities caps = new DesiredCapabilities();
	
	@Test
	public void pcloudy() throws MalformedURLException {
		MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.setCapability("platformName", "Windows");
		capabilities.setCapability("browserName", "MicrosoftEdge");
		capabilities.setCapability("browserVersion", "121");

		HashMap<String, String> bitbarOptions = new HashMap<String, String>();
		bitbarOptions.put("project", "Varadha Farms");
		bitbarOptions.put("testrun", "Search");
		bitbarOptions.put("apiKey", "IgHMBjP1zLc9qaW1iMGhGb1yhYI1JTYN");
		bitbarOptions.put("osVersion", "11");
		bitbarOptions.put("resolution", "1920x1080");
		bitbarOptions.put("seleniumVersion", "4");
		capabilities.setCapability("bitbar:options", bitbarOptions);
		driver = new RemoteWebDriver(new URL("https://eu-desktop-hub.bitbar.com/wd/hub"),capabilities);
		System.out.println("Browser Started");
		driver.get("https://vaaradhifarms.com/");
	}
	

}
