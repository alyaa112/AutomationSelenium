package com.seb.technicalassessment.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

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