package com.QOBOX.web.bdd.integrations.Common_Utils;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class DriverFactory {
	private static DriverFactory instance = null;
	ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	

	private DriverFactory() {

	}

	public static DriverFactory getInstance() {
		if (instance == null) {
			instance = new DriverFactory();
		}
		return instance;
	}


	public final void setWebDriver(String browser) throws Exception {

//		DesiredCapabilities capabilities = new DesiredCapabilities();
		MutableCapabilities capabilities = new MutableCapabilities();
		
		switch (browser.toLowerCase()) {

		case "chrome":
			System.out.println("Browser in driverfactory");
			ChromeOptions chOptions = new ChromeOptions();
//			chOptions.setBinary("C:\\Users\\hp\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe"); 
//			caps.setCapability("os", "Windows");
//			caps.setCapability("osVersion", "11");
//			caps.setCapability("browserVersion", "121");
//			caps.setCapability("apiKey", "MZnVXf9jNLh78ePmM3");
////			caps.setCapability("clientName", "AnemVishnu Priya");		
//			caps.setCapability("email", "vishnu.priya@qo-box.com");
			
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
			
			
			
//			Map<String, Object> chromePrefs = new HashMap<String, Object>();
//			chromePrefs.put("credentials_enable_service", false);
//			chOptions.setExperimentalOption("prefs", chromePrefs);
//			chOptions.addArguments("--no-sandbox");
//			//chOptions.addArguments("--headless"); // !!!should be enabled for Jenkins
//			chOptions.addArguments("--disable-dev-shm-usage"); // !!!should be enabled for Jenkins
//			chOptions.addArguments("--window-size=1920x1080"); // !!!should be enabled for Jenkins
//			chOptions.addArguments("--disable-plugins", "--disable-extensions", "--disable-popup-blocking");
//			chOptions.setCapability(ChromeOptions.CAPABILITY, chOptions);
//			chOptions.addArguments("--remote-allow-origins=*");
////			chOptions. addArguments("--headless");
//			chOptions.setCapability("applicationCacheEnabled", false);
//			System.setProperty("webdriver.chrome.silentOutput", "true");
			webDriver.set(new RemoteWebDriver(new URL("https://eu-desktop-hub.bitbar.com/wd/hub"),capabilities));
			getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			getWebDriver().manage().window().maximize();
			System.out.println("Browser initiated");
			break;


		case "firefox":
			
			webDriver.set(new FirefoxDriver());
			getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			getWebDriver().manage().window().maximize();
			break;

		case "edge":
			
			webDriver.set(new EdgeDriver());
			getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			getWebDriver().manage().window().maximize();
			break;

		case "ie":
			
			webDriver.set(new InternetExplorerDriver());
			getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			getWebDriver().manage().window().maximize();
			break;
			
		case "chromemobilemode":
			Map<String, String> mobileEmulation = new HashMap<String, String>();
			mobileEmulation.put("deviceName", ConfigReader.getValue("ChromeMobileModeDeviceName"));
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			System.setProperty("webdriver.chrome.silentOutput", "true");
			webDriver.set(new ChromeDriver(chromeOptions));
			getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			break;
		}
	}

	

	
	public WebDriver getWebDriver() {
		return webDriver.get();
		
	}

	

	
}