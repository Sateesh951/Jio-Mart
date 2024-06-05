package com.QOBOX.web.bdd.common.hooks;

import java.util.ArrayList;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.QOBOX.web.bdd.integrations.Common_Utils.DriverFactory;
import com.QOBOX.web.bdd.integrations.Report_Utils.ReportManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class CucumberHooks {
	public static ArrayList<String> passedTests = new ArrayList<String>();
	public static ArrayList<String> failedTests = new ArrayList<String>();
	public static ArrayList<String> totalTestCases = new ArrayList<String>();

	private static String str_Execution_TYPE = "Web_UI";

	public String str_BrowserType = System.getProperty("Browser");
	DriverFactory driverFactory = DriverFactory.getInstance();


	@Before
	public void before(Scenario scenario) throws Exception {
		System.out.println("+++++++++++++++++++before hooks++++++++++++++++++");

		if (str_Execution_TYPE.equalsIgnoreCase("Web_UI")) {
			ReportManager.startTest(scenario.getName(), "SMOKE");
			System.out.println("Execution started @ " + str_BrowserType + " browser & for type : Web UI");
			try {
				System.out.println("Browser in BeforeHooks");
				driverFactory.setWebDriver(str_BrowserType.trim());
				System.out.println("Browser after  setwebdriver");
			} catch (Exception e) {

				e.printStackTrace();
			}
		} else {
			throw new Exception(
					"[-] Please set exection type[Web_UI] value in cucumberhooks class line number 21");
		}
	}

	@After
	public void after(Scenario scenario) throws Exception {
		System.out.println("+++++++++++++++++++after hooks+++++++++++++++++++");

		if (str_Execution_TYPE.equalsIgnoreCase("Web_UI")) {
			totalTestCases.add(scenario.getName());
			if (totalTestCases.contains(scenario.getName())) {
				System.out.println("Removing TC from totalTestCases: " + scenario.getName());
				totalTestCases.remove(scenario.getName());
			}
			if (failedTests.contains(scenario.getName())) {
				System.out.println("Removing TC from failedTests: " + scenario.getName());
				failedTests.remove(scenario.getName());
			}
			if (passedTests.contains(scenario.getName())) {
				System.out.println("Removing TC from passedTests: " + scenario.getName());
				passedTests.remove(scenario.getName());
			}
			if (scenario.isFailed()) {
				failedTests.add(scenario.getName());
				final byte[] screenshot = ((TakesScreenshot) DriverFactory.getInstance().getWebDriver())
                        .getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
                scenario.log("ScreenShot Attached");
			} else {
				passedTests.add(scenario.getName());
			}
			
		
		} else {
			throw new Exception(
					"[-] Please set exection type[Web_UI] value in cucumberhooks class line number 21");
		}

	}

}
