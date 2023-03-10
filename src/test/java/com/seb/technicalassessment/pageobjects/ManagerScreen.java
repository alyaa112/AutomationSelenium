package com.seb.technicalassessment.pageobjects;

import com.seb.technicalassessment.utility.AppLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ManagerScreen implements AppLocators.ManagerScreen {
    //page locator for add cust option
    @FindBy(css = addCustomerOption)
    public WebElement ADD_CUST_OPTION;

    //page locator for open acc option
    @FindBy(css = managerTasksButtons)
    public WebElement MANAGER_TASKS_BUTTONS;

    //page locator for cust option
    @FindBy(css = customersOption)
    public WebElement CUST_OPTION;

    //page locator for details textfields
    @FindBy(css = detailsTextfield)
    public List<WebElement> DETAILS_TEXTFIELD;

    //page locator for details textfields
    @FindBy(css = addCustomerButton)
    public WebElement ADD_CUSTOMER_BUTTON;

    //page locator for customer search bar
    @FindBy(xpath = customerSearchBar)
    public WebElement CUSTOMER_SEARCH_BAR;

    //page locator for table field
    @FindBy(xpath = tableLastNameCol)
    public List<WebElement> TABLE_LASTNAME_COL;

    //page locator for delete button
    @FindBy(xpath = deleteButton)
    public List<WebElement> DELETE_BUTTON;
}
