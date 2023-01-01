package com.seb.technicalassessment.pages;

import com.seb.technicalassessment.pageobjects.ManagerScreen;
import com.oracle.tools.packager.Log;
import com.seb.technicalassessment.utility.CommonTests;
import com.seb.technicalassessment.utility.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class ManagerScreenPage extends CommonTests {

    ManagerScreen managerScreen = new ManagerScreen();

    String[] firstName = {"Christopher","Frank","Christopher",
            "Connely","Jackson","Minka","Jackson","Lawrence","Mariotte"};
    String[] lastName = {"Connely","Christopher","Minka",
            "Jackson","Frank","Jackson","Connely","Zimmerman","Tova"};
    String[] postcode = {"L789C349","A897N450","M098Q585",
            "L789C349","L789C349","A897N450","L789C349","L789C349","L789C349"};


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
        for (int i=0; i<firstName.length; i++) {
            managerScreen.DETAILS_TEXTFIELD.get(Constants.CommonDetails.FIRST_NAME_TEXTFIELD).sendKeys(firstName);
            managerScreen.DETAILS_TEXTFIELD.get(Constants.CommonDetails.LAST_NAME_TEXTFIELD).sendKeys(lastName);
            managerScreen.DETAILS_TEXTFIELD.get(Constants.CommonDetails.POSTCODE_TEXTFIELD).sendKeys(postcode);
            clickAddCustomerButton();
            clickOKOnPopup();
        }
    }

    //method to click Submit button
    public void clickAddCustomerButton() {
        managerScreen.ADD_CUSTOMER_BUTTON.click();
        Log.info("Clicked on add customer button");
    }

    //method to click Ok on popup
    public void clickOKOnPopup() {
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

    //method to click on Customer section
    public void clickOnCustomerButton() {
        managerScreen.CUST_OPTION.click();
    }

    //method to check customer details
    public void checkCustomerDetails() {
        for (int i=0; i<lastName.length; i++) {
            verifyCustomersAreAdded(String.valueOf(lastName));
        }
        Log.info("All customer details are added");
    }

    //method to verify customer details are added()
    public void verifyCustomersAreAdded(String name) {
        int row = managerScreen.TABLE_LASTNAME_COL.size();
        for (int i = 0; i < row; i++) {

            String cellValue = remoteDriver.findElement(By.xpath("//table[@class='table table-bordered " +
                    "table-striped']/tbody/tr[" + i + "]/td[]")).getText();

            if (cellValue.equalsIgnoreCase(name)) {
                Log.info("Customer details added : " + (i+1));
            }
        }
    }

    //method to verify customer details are added
    public void deleteCustomerDetails() {

        String[] deleteFirstName = {"Jackson","Christopher"};
        String[] deleteLastName = {"Frank","Connely"};

        for (int i=0; i<firstName.length; i++) {
            searchCustName(String.valueOf(deleteFirstName));
            verifyToDeleteCustName(String.valueOf(deleteLastName));
        }
    }

    //method to search customer first name
    public void searchCustName(String name) {
        managerScreen.CUSTOMER_SEARCH_BAR.click();
        managerScreen.CUSTOMER_SEARCH_BAR.sendKeys(name);
        Log.info("Search name");
    }

    //method to verify customer first and last name is correct to delete
    public void verifyToDeleteCustName(String name) {
        int row = managerScreen.TABLE_LASTNAME_COL.size();
        for (int i=0; i<row; i++) {

            String cellValue = remoteDriver.findElement(By.xpath("//table[@class='table table-bordered " +
                    "table-striped']/tbody/tr[" + i + "]/td[]")).getText();
            WebElement DELETE_BUTTON = remoteDriver.findElement(By.xpath("//tr[" + i + "]/?/?/button[@innertext" +
                    "='Delete']"));

            if (cellValue.equalsIgnoreCase(name))
            {
                DELETE_BUTTON.click();
                Log.info("Customer details are deleted");
            }
        }
    }
}