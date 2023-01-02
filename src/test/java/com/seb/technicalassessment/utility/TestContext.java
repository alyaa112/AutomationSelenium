package com.seb.technicalassessment.utility;

import com.seb.technicalassessment.appobjectmanager.AppObjectManager;
import com.seb.technicalassessment.utility.DriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestContext {

    private AppObjectManager appObjectManager;
    public TestContext() {
        appObjectManager = new AppObjectManager((RemoteWebDriver) DriverManager.getDriver());
    }
    public AppObjectManager getAppObjectManager() {
        return appObjectManager;
    }
}
