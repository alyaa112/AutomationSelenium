package com.seb.technicalassessment.runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json", "html:target/cucumber-reports", "junit:target/cucumber-reports/Cucumber.xml"},
        features = {"src/test/feature/"},
        glue = {"com.seb.technicalassessment.stepdefinition"},
        tags = "@SEBTest",
        monochrome = true
    )

public class RunnerTest {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(dataProvider = "feature")
    public void features(PickleWrapper eventWrapper, FeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(eventWrapper.getPickle());
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }

}