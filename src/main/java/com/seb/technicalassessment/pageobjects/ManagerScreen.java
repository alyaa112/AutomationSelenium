package com.seb.technicalassessment.pageobjects;

import com.seb.technicalassessment.utility.AppLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ManagerScreen implements AppLocators.ManagerScreen {
    //page locator for add cust option
    @FindBy(xpath = addCustomerOption)
    public WebElement ADD_CUST_OPTION;

    //page locator for open acc option
    @FindBy(xpath = openAccountOption)
    public WebElement OPEN_ACC_OPTION;

    //page locator for cust option
    @FindBy(xpath = customersOption)
    public WebElement CUST_OPTION;

    //page locator for details textfields
    @FindBy(css = detailsTextfield)
    public List<WebElement> DETAILS_TEXTFIELD;

    //page locator for details textfields
    @FindBy(css = addCustomerButton)
    public WebElement ADD_CUSTOMER_BUTTON;
}
