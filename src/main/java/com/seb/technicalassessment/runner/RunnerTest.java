package com.seb.technicalassessment.runner;

import io.cucumber.junit.CucumberOptions;

    @CucumberOptions(
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json", "html:target/cucumber-reports", "junit:target/cucumber-reports/Cucumber.xml"},
        features = {"src/main/feature/"},
        glue = {"com.seb.technicalassessment.stepdefinition"},
        tags = "@SEBTest",
        monochrome = true
    )

public class RunnerTest {
}