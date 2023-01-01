package com.seb.technicalassessment.stepdefinition;

import com.seb.technicalassessment.pages.ManagerScreenPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

public class DeleteCustomerDetailsStepDefinition {

    ManagerScreenPage managerScreenPage;

    @When("^user deletes customer details$")
    public void deleteCustDetails() {
        managerScreenPage.deleteCustomerDetails();
    }

    @Then("^deleted customer details should not be visible on screen$")
    public void deletedDetailsNotVisible() {

    }
}
