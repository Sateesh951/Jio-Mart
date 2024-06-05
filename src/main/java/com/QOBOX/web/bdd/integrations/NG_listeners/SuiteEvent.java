package com.QOBOX.web.bdd.integrations.NG_listeners;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IExecutionListener;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.TestListenerAdapter;

import com.QOBOX.web.bdd.integrations.Common_Utils.DriverFactory;
import com.QOBOX.web.bdd.integrations.Report_Utils.ReportManager;

public class SuiteEvent extends TestListenerAdapter implements ISuiteListener, IExecutionListener, IReporter {

	static DriverFactory driverFactory = WebEvent.driverFactory;
	public static String str_Execution_TYPE;

	@Override
	public void onFinish(ISuite arg0) {

	}

	@Override
	public void onStart(ISuite arg0) {

	}

	public void onExecutionStart() {

		System.out.println("In on execution start");

		str_Execution_TYPE = System.getProperty("execType", "Web_UI");

		System.out.println("Execution type is: " + String.valueOf(str_Execution_TYPE));

		if (str_Execution_TYPE.equalsIgnoreCase("Web_UI")) {
			ReportManager.startReport();
		} else {
			System.out.println("[-] Please set exection type[Web_UI] value in cucumberhooks");
		}
	}

	@Override
	public void onExecutionFinish() {

		if (str_Execution_TYPE.equalsIgnoreCase("Web_UI")) {
			ReportManager.extent.setSystemInfo("Browser Name", SuiteEvent.getBrowser());
			ReportManager.extent.setSystemInfo("Browser Version", SuiteEvent.getVersion());
			ReportManager.endReport();
			System.out.println("Execution finished");

		} else {
			System.out.println("[-] Please set exection type[Web_UI or Mobile_UI or API] value in cucumberhooks");
		}

	}

	public static String getBrowser() {
		String browserName = null;
		if (str_Execution_TYPE.equalsIgnoreCase("Web_UI")) {
			Capabilities cap = ((RemoteWebDriver) DriverFactory.getInstance().getWebDriver()).getCapabilities();
			browserName = cap.getBrowserName().toLowerCase();

		}
		return browserName;

	}

	public static String getVersion() {
		String v = null;
		if (str_Execution_TYPE.equalsIgnoreCase("Web_UI")) {
			Capabilities cap = ((RemoteWebDriver) DriverFactory.getInstance().getWebDriver()).getCapabilities();
			v = cap.getBrowserVersion().toString();

		}
		return v;

	}

}
