package com.seb.technicalassessment.pageobjects;

import com.seb.technicalassessment.utility.AppLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginScreen implements AppLocators.LoginScreen {

    //page object for user options
    @FindBy(xpath = bankManagerOption)
    public WebElement BANK_MANAGER_OPTION;
}
