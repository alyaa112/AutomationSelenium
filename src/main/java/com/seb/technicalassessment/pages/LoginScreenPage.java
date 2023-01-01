package com.seb.technicalassessment.pages;

import com.seb.technicalassessment.pageobjects.LoginScreen;
import com.seb.technicalassessment.utility.BaseTest;
import com.seb.technicalassessment.utility.CommonTests;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginScreenPage extends CommonTests {

    LoginScreen loginScreen = new LoginScreen();

    public LoginScreenPage(RemoteWebDriver remoteWebDriver) {
        PageFactory.initElements(remoteWebDriver, loginScreen);
    }

    //Method to launch web app
    public void launchWebApp() {
        BaseTest.setup();
        System.out.print("Application launched");
    }

    //method to verify login screen
    public void verifyLoginScreenVisibility() {
        loginScreen.MENU_HEADER.isDisplayed();
        loginScreen.USER_OPTION.get(0).isDisplayed();
        System.out.print("Menu screen is visible");
    }

    //method to click on user option
    public void clickUserOption(int option) {
        loginScreen.USER_OPTION.get(option).click();
        System.out.print("Clicked on " + option);
    }
}
