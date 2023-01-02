package com.seb.technicalassessment.pages;

import com.seb.technicalassessment.pageobjects.ManagerScreen;
import com.seb.technicalassessment.utility.CommonTests;
import com.seb.technicalassessment.utility.Constants;
import lombok.SneakyThrows;
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


    String[] deleteFirstName = {"Jackson","Christopher"};
    String[] deleteLastName = {"Frank","Connely"};


    public ManagerScreenPage(RemoteWebDriver remoteWebDriver) {
        PageFactory.initElements(remoteWebDriver, managerScreen);
    }

    //method to verify screen visibility
    public void verifyManagerScreenVisibility() {
        waitForPageLoadedState();
        managerScreen.MANAGER_TASKS_BUTTONS.isDisplayed();
        System.out.println("Manager screen is visible");
    }

    //method to click on add customers
    public void clickAddCust() {
        managerScreen.ADD_CUST_OPTION.click();
        System.out.println("Clicked on add cust option");
    }

    //method to add customer details
    public void addCustDetails() {
        waitForPageLoadedState();
        for (int i=0; i<firstName.length; i++) {
            managerScreen.DETAILS_TEXTFIELD.get(Constants.CommonDetails.FIRST_NAME_TEXTFIELD).sendKeys(firstName[i]);
            managerScreen.DETAILS_TEXTFIELD.get(Constants.CommonDetails.LAST_NAME_TEXTFIELD).sendKeys(lastName[i]);
            managerScreen.DETAILS_TEXTFIELD.get(Constants.CommonDetails.POSTCODE_TEXTFIELD).sendKeys(postcode[i]);
            clickAddCustomerButton();
            clickOKOnPopup();
        }
    }

    //method to click Submit button
    @SneakyThrows
    public void clickAddCustomerButton() {
        managerScreen.ADD_CUSTOMER_BUTTON.click();
        System.out.println("Clicked on add customer button");
        Thread.sleep(2000);
    }

    //method to click Ok on popup
    public void clickOKOnPopup() {
        if (alertVisibility()) {
            System.out.println("Details are saved");
            try {
                closeAlert();
                System.out.println("Close popup");
            } catch (Exception error){
                System.out.println("Cannot close popup");
            }
        }
    }

    //method to click on Customer section
    public void clickOnCustomerButton() {
        managerScreen.CUST_OPTION.click();
    }

    //method to verify visibility of Customer section
    public void verifyCustomerSectVisibility() {
        waitForPageLoadedState();
        managerScreen.CUSTOMER_SEARCH_BAR.isDisplayed();
    }

    //method to check customer details
    public void checkCustomerDetails() {
        for (int i=0; i<lastName.length; i++) {
            verifyCustomersAreAdded(String.valueOf(lastName[i]));
        }
        System.out.println("All customer details are added");
    }

    //method to verify customer details are added()
    public void verifyCustomersAreAdded(String name) {
        int row = managerScreen.TABLE_LASTNAME_COL.size();
        for (int i = 0; i < row; i++) {

            String cellValue = managerScreen.TABLE_LASTNAME_COL.get(i).getText();

            if (cellValue.equalsIgnoreCase(name)) {
                System.out.println("Customer details added : " + (i+1));
            }
        }
    }

    //method to verify customer details are added
    @SneakyThrows
    public void deleteCustomerDetails() {
        for (int i=0; i<firstName.length; i++) {
            searchCustName(String.valueOf(deleteFirstName[i]));
            verifyToDeleteCustName(String.valueOf(deleteLastName[i]));
            Thread.sleep(2000);
            clearSearchBar();
        }
    }

    //method to clear textfield
    public void clearSearchBar() {
        managerScreen.CUSTOMER_SEARCH_BAR.click();
        managerScreen.CUSTOMER_SEARCH_BAR.clear();
    }

    //method to search customer first name
    public void searchCustName(String name) {
        managerScreen.CUSTOMER_SEARCH_BAR.click();
        managerScreen.CUSTOMER_SEARCH_BAR.sendKeys(name);
        System.out.println("Search name");
    }

    //method to verify customer first and last name is correct to delete
    @SneakyThrows
    public void verifyToDeleteCustName(String name) {
        int row = managerScreen.TABLE_LASTNAME_COL.size();
        for (int i=0; i<row; i++) {

            String cellValue = managerScreen.TABLE_LASTNAME_COL.get(i).getText();
            System.out.println("Cellvalue : " + cellValue + " " + i);
            if (cellValue.equalsIgnoreCase(name))
            {
                managerScreen.DELETE_BUTTON.get(i).click();
                System.out.println("Customer details are deleted");
                break;
            }
        }
    }

    //method to search first name to delete
    public void searchToVerifyDeletedCust() {
        for (int i=0; i<firstName.length; i++) {
            searchCustName(String.valueOf(deleteFirstName[i]));
            verifyDeletedCustAreUnseen(String.valueOf(deleteLastName[i]));
        }
    }

    //method to verify deleted customers are not seen in table
    public void verifyDeletedCustAreUnseen(String name) {
        int row = managerScreen.TABLE_LASTNAME_COL.size();
        for (int i=0; i<row; i++) {

            String cellValue = managerScreen.TABLE_LASTNAME_COL.get(i).getText();

            if (!cellValue.equalsIgnoreCase(name))
            {
                System.out.print("Customer details are not visible in table");
            }
        }
    }
}