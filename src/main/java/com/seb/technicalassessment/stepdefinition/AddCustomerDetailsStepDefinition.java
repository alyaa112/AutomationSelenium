package com.seb.technicalassessment.stepdefinition;

import com.seb.technicalassessment.pages.ManagerScreenPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddCustomerDetailsStepDefinition {

    ManagerScreenPage managerScreenPage;

    @When("^user adds new customer details$")
    public void addNewCustDetails() {
        managerScreenPage.clickAddCust();
        managerScreenPage.addCustDetails();
    }

    @Then("^customer details should be saved$")
    public void custDetailsShouldBeSaved() {
        managerScreenPage.checkCustomerDetails();
    }
}
