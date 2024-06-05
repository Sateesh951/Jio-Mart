package com.QOBOX.web.bdd.integrations.Common_Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.QOBOX.web.bdd.constants.Constants;

public final class ScreenshotUtils {

	public static String takeScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String source = ts.getScreenshotAs(OutputType.BASE64);
		FileUtils.copyDirectory(new File(source), new File(Constants.SCREENSHOTS_PATH));
		return source;
	}

}
