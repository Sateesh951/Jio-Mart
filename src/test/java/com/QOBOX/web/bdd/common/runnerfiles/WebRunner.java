package com.QOBOX.web.bdd.common.runnerfiles;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.QOBOX.web.bdd.integrations.NG_listeners.SuiteEvent;
import com.QOBOX.web.bdd.integrations.NG_listeners.WebEvent;

@Listeners({ SuiteEvent.class, WebEvent.class })
@CucumberOptions(features = { "src/test/java/com/QOBOX/web/bdd/features" }, glue = {
		"com/QOBOX/web/bdd/stepdefinations", "com/QOBOX/web/bdd/common/hooks" }, tags = "@groceries", plugin = { "pretty",
				"html:target/site/cucumber-pretty/cucumber.html", "json:target/cucumber/cucumber.json",
				"rerun:target/rerun.txt",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }, monochrome = true, publish = true, dryRun = false)

//com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:

public class WebRunner {

	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		System.out.println("@Before class");
		// ReportManager.startTestAPI("Test", "Smoke");
	}

	@Test(groups = "cucumber", description = "Run Cucumber Scenario", dataProvider = "scenarios")
	public void scenario(PickleWrapper pickleEventWrapper, FeatureWrapper cucumberFeatureWrapper) throws Throwable {
		testNGCucumberRunner.runScenario(pickleEventWrapper.getPickle());
	}

	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		System.out.println("@Data provider");
		if (testNGCucumberRunner == null) {
			testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		}

		return testNGCucumberRunner.provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() {
		System.out.println("@Afterclass");
		testNGCucumberRunner.finish();
	}
}
