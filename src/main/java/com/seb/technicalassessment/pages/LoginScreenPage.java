package com.seb.technicalassessment.pages;

import com.oracle.tools.packager.Log;
import com.seb.technicalassessment.pageobjects.LoginScreen;
import com.seb.technicalassessment.utility.BaseTest;
import com.seb.technicalassessment.utility.CommonTests;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.sql.DriverManager;

public class LoginScreenPage extends CommonTests {

    LoginScreen loginScreen = new LoginScreen();

    public LoginScreenPage(RemoteWebDriver remoteWebDriver) {
        PageFactory.initElements(remoteWebDriver, loginScreen);
    }

    //Method to launch web app
    public void launchWebApp() {
        BaseTest.setup();
        Log.info("Application launched");
    }

    //method to verify login screen
    public void verifyLoginScreenVisibility() {
        loginScreen.MENU_HEADER.isDisplayed();
        loginScreen.USER_OPTION.get(0).isDisplayed();
        Log.info("Menu screen is visible");
    }

    //method to click on user option
    public void clickUserOption(int option) {
        loginScreen.USER_OPTION.get(option).click();
        Log.info("Clicked on " + option);
    }
}
