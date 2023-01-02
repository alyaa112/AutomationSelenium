package com.seb.technicalassessment.appobjectmanager;

import com.seb.technicalassessment.pages.*;
import com.seb.technicalassessment.utility.DriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AppObjectManager {

    RemoteWebDriver remoteWebDriver;
    LoginScreenPage loginScreenPage;
    ManagerScreenPage managerScreenPage;


    public AppObjectManager(RemoteWebDriver remoteDriver) {
        this.remoteWebDriver = remoteDriver;
    }

    public LoginScreenPage getLoginScreen() {
        return (loginScreenPage == null) ? new LoginScreenPage((RemoteWebDriver) DriverManager.getDriver()) : loginScreenPage;
    }

    public ManagerScreenPage getManagerScreen() {
        return (managerScreenPage == null) ? new ManagerScreenPage((RemoteWebDriver) DriverManager.getDriver()) :
                managerScreenPage;
    }

}