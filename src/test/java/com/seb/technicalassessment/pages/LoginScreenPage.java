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
    public void launchWebApp() throws InterruptedException {
        BaseTest.setup();
        System.out.println("Application launched");
    }

    //method to verify login screen
    public void verifyLoginScreenVisibility() {
        waitForPageLoadedState();
        loginScreen.BANK_MANAGER_OPTION.isDisplayed();
        System.out.println("Menu screen is visible");
    }

    //method to click on user option
    public void clickUserOption() {
        loginScreen.BANK_MANAGER_OPTION.click();
        System.out.println("Clicked on bank manager");
    }
}
