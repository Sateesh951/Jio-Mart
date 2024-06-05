package com.QOBOX.web.bdd.integrations.NG_listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.QOBOX.web.bdd.integrations.Common_Utils.DriverFactory;
import com.QOBOX.web.bdd.integrations.Common_Utils.VideoReord;
import com.QOBOX.web.bdd.integrations.Report_Utils.ReportManager;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class WebEvent implements ITestListener {

	static DriverFactory driverFactory = DriverFactory.getInstance();
	public static String strBrowser=System.getProperty("Browser");

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("+++++++++++++++++++++onTestStart++++++++++++++++++++");
		System.out.println("Execution started @ " + strBrowser + " browser & for type : Web UI");
		try {
			VideoReord.startRecord(arg0.getMethod().getMethodName());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		
		System.out.println("+++++++++++++++++++++onTestSuccess++++++++++++++++++++");

		try {
			driverFactory.getWebDriver().quit();
			VideoReord.stopRecord();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {

		System.out.println("+++++++++++++++++++++onTestFailure++++++++++++++++++++");
		ReportManager.logFail(iTestResult.getThrowable().toString());

		try {
			ReportManager.logScreenshot();

		} catch (IOException e) {

			e.printStackTrace();
		}
		ReportManager.endCurrentTest();

		try {
			VideoReord.stopRecord();
			driverFactory.getWebDriver().quit();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
	
		String logText = "<b>" + arg0.getMethod().getMethodName() + " is skipped.</b>";
		Markup markup_message = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);

	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext arg0) {

		// strBrowser = arg0.getCurrentXmlTest().getParameter("browser");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

}
