package com.seb.technicalassessment.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json", "html:target/cucumber-reports/Cucumber.html",
                "junit:target/cucumber-reports/Cucumber.xml"},
        features = {"src/test/feature/"},
        glue = {"com.seb.technicalassessment.stepdefinition"},
        tags = "@SEBTest",
        monochrome = true
    )

public class RunnerTest {
}