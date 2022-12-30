package com.seb.technicalassessment.pages;

import com.seb.technicalassessment.pageobjects.ManagerScreen;
import com.oracle.tools.packager.Log;
import com.seb.technicalassessment.utility.CommonTests;
import com.seb.technicalassessment.utility.Constants;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class ManagerScreenPage extends CommonTests {

    ManagerScreen managerScreen = new ManagerScreen();

    public ManagerScreenPage(RemoteWebDriver remoteWebDriver) {
        PageFactory.initElements(remoteWebDriver, managerScreen);
    }

    //method to verify screen visibility
    public void verifyManagerScreenVisibility() {
        managerScreen.ADD_CUST_OPTION.isDisplayed();
        managerScreen.OPEN_ACC_OPTION.isDisplayed();
        managerScreen.CUST_OPTION.isDisplayed();
        Log.info("Manager screen is visible");
    }

    //method to click on add customers
    public void clickAddCust() {
        managerScreen.ADD_CUST_OPTION.click();
        Log.info("Clicked on add cust option");
    }

    //method to add customer details
    public void addCustDetails() {
        String[] firstName = {"Christopher","Frank","Christopher",
                "Connely","Jackson","Minka","Jackson","Lawrence","Mariotte"};
        String[] lastName = {"Connely","Christopher","Minka",
                "Jackson","Frank","Jackson","Connely","Zimmerman","Tova"};
        String[] postcode = {"L789C349","A897N450","M098Q585",
                "L789C349","L789C349","A897N450","L789C349","L789C349","L789C349"};

        for (int i=0; i<firstName.length; i++) {
            managerScreen.DETAILS_TEXTFIELD.get(Constants.CommonDetails.FIRST_NAME_TEXTFIELD).sendKeys(firstName);
            managerScreen.DETAILS_TEXTFIELD.get(Constants.CommonDetails.LAST_NAME_TEXTFIELD).sendKeys(lastName);
            managerScreen.DETAILS_TEXTFIELD.get(Constants.CommonDetails.POSTCODE_TEXTFIELD).sendKeys(postcode);
            clickAddCustomerButton();
            verifyCustomerDetailsAdded();
        }
    }

    //method to click Submit button
    public void clickAddCustomerButton() {
        managerScreen.ADD_CUSTOMER_BUTTON.click();
        Log.info("Clicked on add customer button");
    }

    //method to verify customer details are added
    public void verifyCustomerDetailsAdded() {
        if (alertVisibility()) {
            Log.info("Details are saved");
            try {
                closeAlert();
                Log.info("Close popup");
            } catch (Exception error){
                Log.info("Cannot close popup");
            }
        }
    }




}
