package com.seb.technicalassessment.stepdefinition;

import com.seb.technicalassessment.pages.LoginScreenPage;
import com.seb.technicalassessment.pages.ManagerScreenPage;
import com.seb.technicalassessment.utility.Constants;
import com.seb.technicalassessment.utility.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class LoginStepDefinition {

    LoginScreenPage loginScreenPage;
    ManagerScreenPage managerScreenPage;

    public LoginStepDefinition(TestContext context) {
        loginScreenPage = context.getAppObjectManager().getLoginScreen();
        managerScreenPage = context.getAppObjectManager().getManagerScreen();
    }

    @Given("^user login as bank manager$")
    public void loginAsBankManager() throws InterruptedException {
        loginScreenPage.launchWebApp();
        loginScreenPage.verifyLoginScreenVisibility();
        loginScreenPage.clickUserOption();
    }

    @And("^manager screen is visible$")
    public void managerScreenIsVisible() {
        managerScreenPage.verifyManagerScreenVisibility();
    }
}
