package com.seb.technicalassessment.utility;

public interface AppLocators {

    interface LoginScreen {
        String menuHeader = "//strong[@class='mainHeading']";
        String userOption = ".btn.btn-lg.btn-primary";
    }

    interface ManagerScreen {
        String addCustomerOption = "///button[@innertext='Add Customer']";
        String openAccountOption = "///button[@innertext='Open Account']";
        String customersOption = "///button[@innertext='Customers']";
        String detailsTextfield = "form .form-group [type]";
        String addCustomerButton = ".btn-default";
    }
}
