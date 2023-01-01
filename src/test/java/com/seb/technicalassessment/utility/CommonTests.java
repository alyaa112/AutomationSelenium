package com.seb.technicalassessment.utility;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class CommonTests {

    public RemoteWebDriver remoteDriver;

    protected CommonTests(RemoteWebDriver remoteDriver){
        this.remoteDriver = remoteDriver;
    }

    protected CommonTests() {}

    //To check if alert is present
    protected boolean alertVisibility() {
        try {
            remoteDriver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    //To close alert popup
    protected void closeAlert() {
        remoteDriver.switchTo().alert().accept();
    }
}
