package com.seb.technicalassessment.utility;

import lombok.SneakyThrows;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class CommonTests {

    public RemoteWebDriver remoteDriver;

    protected CommonTests(RemoteWebDriver remoteDriver){
        this.remoteDriver = remoteDriver;
    }

    protected CommonTests() {}

    //To check if alert is present
    protected boolean alertVisibility() {
        try {
            DriverManager.getDriver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    //To close alert popup
    protected void closeAlert() {
        DriverManager.getDriver().switchTo().alert().accept();
    }

    @SneakyThrows
    protected void waitForPageLoadedState() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wd) {
                return ((JavascriptExecutor) wd).executeScript(Constants.WebConfig.WEB_PAGE_STATE).toString().equals(Constants.WebConfig.WEB_PAGE_STATUS);
            }
        };
        try {
            Thread.sleep(3000);
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(60));
            wait.until(expectation);
        } catch (RuntimeException | InterruptedException error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

}
