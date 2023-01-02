package com.seb.technicalassessment.stepdefinition;

import com.seb.technicalassessment.pages.ManagerScreenPage;
import com.seb.technicalassessment.utility.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddAndDeleteCustomerDetailsStepDefinition {

    ManagerScreenPage managerScreenPage;

    public AddAndDeleteCustomerDetailsStepDefinition(TestContext context) {
        managerScreenPage = context.getAppObjectManager().getManagerScreen();
    }

    @When("^user adds new customer details and verify it$")
    public void addNewCustDetailsAndVerify() {
        managerScreenPage.clickAddCust();
        managerScreenPage.addCustDetails();
        managerScreenPage.clickOnCustomerButton();
        managerScreenPage.verifyCustomerSectVisibility();
        managerScreenPage.checkCustomerDetails();
    }

    @When("^user deletes some customers$")
    public void deleteCustDetails() {
        managerScreenPage.deleteCustomerDetails();
    }

    @Then("^deleted customer details should not be visible on screen$")
    public void deletedDetailsNotVisible() {
        managerScreenPage.searchToVerifyDeletedCust();
    }
}
