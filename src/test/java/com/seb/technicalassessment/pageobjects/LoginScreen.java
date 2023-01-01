package com.seb.technicalassessment.pageobjects;

import com.seb.technicalassessment.utility.AppLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginScreen implements AppLocators.LoginScreen {
    //page object for header bank
    @FindBy(xpath = menuHeader)
    public WebElement MENU_HEADER;

    //page object for user options
    @FindBy(xpath = userOption)
    public List<WebElement> USER_OPTION;
}
