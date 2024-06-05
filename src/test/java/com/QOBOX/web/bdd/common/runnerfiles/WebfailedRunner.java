package com.QOBOX.web.bdd.common.runnerfiles;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.QOBOX.web.bdd.integrations.NG_listeners.SuiteEvent;
import com.QOBOX.web.bdd.integrations.NG_listeners.WebEvent;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@Listeners({ SuiteEvent.class, WebEvent.class })

@CucumberOptions(features = { "@target/rerun.txt" }, glue = { "com/QOBOX/web/bdd/stepdefinations",
		"com/QOBOX/web/bdd/common/hooks" }, tags = "@Login", plugin = { "pretty",
				"html:target/site/cucumber-pretty/cucumber.html",
				"json:target/cucumber/cucumber.json", }, monochrome = true, publish = true, dryRun = false)

public class WebfailedRunner {

	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		System.out.println("@Before class");
	}

	@Test(groups = "cucumber", description = "Run Cucumber Scenario", dataProvider = "scenarios")
	public void scenario(PickleWrapper pickleEventWrapper, FeatureWrapper cucumberFeatureWrapper) throws Throwable {
		testNGCucumberRunner.runScenario(pickleEventWrapper.getPickle());
	}

	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		System.out.println("@Data provider");
		return testNGCucumberRunner.provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() {
		System.out.println("@Afterclass");
		testNGCucumberRunner.finish();
	}
}
