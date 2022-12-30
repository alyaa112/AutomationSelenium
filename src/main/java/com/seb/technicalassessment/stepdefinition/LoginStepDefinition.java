package com.seb.technicalassessment.stepdefinition;

import com.seb.technicalassessment.pages.LoginScreenPage;
import com.seb.technicalassessment.pages.ManagerScreenPage;
import com.seb.technicalassessment.utility.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class LoginStepDefinition {

    LoginScreenPage loginScreenPage;
    ManagerScreenPage managerScreenPage;

    @Given("^user login as bank manager$")
    public void loginAsBankManager() {

        loginScreenPage.verifyLoginScreenVisibility();
        loginScreenPage.clickUserOption(Constants.CommonDetails.BANK_MANAGER_OPTION);
    }

    @And("^manager screen is visible$")
    public void managerScreenIsVisible() {
        managerScreenPage.verifyManagerScreenVisibility();
    }
}
