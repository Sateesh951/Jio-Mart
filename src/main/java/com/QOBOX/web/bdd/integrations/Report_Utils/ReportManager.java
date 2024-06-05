package com.QOBOX.web.bdd.integrations.Report_Utils;

import static com.QOBOX.web.bdd.constants.Constants.ICON_SOCIAL_GITHUB;
import static com.QOBOX.web.bdd.constants.Constants.ICON_SOCIAL_LINKEDIN;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.QOBOX.web.bdd.constants.Constants;
import com.QOBOX.web.bdd.integrations.Common_Utils.DriverFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {

	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static Map<Long, ExtentTest> testMap = new HashMap<>();
	public static Map<String, ExtentTest> extentMap = new HashMap<>();

	public static void startReport() {

		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(Constants.extent_reportPath);
			
			extent.attachReporter(spark);
          //  spark.viewConfigurer().viewOrder().as(new ViewName[] {ViewName.CATEGORY}).apply();
			// spark.config().setEncoding("utf-8");
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("DEMO Report");
			spark.config().setReportName("DEMO WEB UI REPORT");

			extent.setSystemInfo("Organization", "QOBOX");
			extent.setSystemInfo("Employee",
					"<b> Test User1</b>" + " " + ICON_SOCIAL_LINKEDIN + " " + ICON_SOCIAL_GITHUB);
			extent.setSystemInfo("Domain", "Engineering (IT - Software)" + "  " + Constants.ICON_LAPTOP);
			extent.setSystemInfo("Skill", "Test Automation Engineer");

		}

	}

	public static void startTest(String testName, String categories) {

		ExtentTest test = extent.createTest(testName);
		test.assignCategory(categories);
		testMap.put(Thread.currentThread().getId(), test);
		extentMap.put(testName, test);
	}

	public static void logScreenshot() throws IOException {
		
		Media mediaModel = MediaEntityBuilder.createScreenCaptureFromBase64String(
				ScreenshotUtil.takeScreenshot(DriverFactory.getInstance().getWebDriver())).build();
		getCurrentTest().fail("", mediaModel);

	}

	public static void logPass(String message) {
		getCurrentTest().log(Status.PASS, message);

	}

	public static void logFail(String message) {
		getCurrentTest().log(Status.FAIL, message);
	}

	public static void logInfo(String message) {
		getCurrentTest().log(Status.INFO, message);

	}

	public static void endCurrentTest() {
		getCurrentTest().getExtent().flush();

		testMap.remove(Thread.currentThread().getId());
	}

	public static ExtentTest getCurrentTest() {
		return testMap.get(Thread.currentThread().getId());

	}

	public static void endReport() {

		extent.flush();
	}

}
