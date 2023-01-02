package com.seb.technicalassessment.utility;

public interface AppLocators {

    interface LoginScreen {
        String bankManagerOption = "//button[.='Bank Manager Login']";
    }

    interface ManagerScreen {
        String addCustomerOption = "[ng-click='addCust()']";
        String managerTasksButtons = ".center > button";
        String customersOption = "[ng-click='showCust()']";
        String detailsTextfield = "form .form-group [type]";
        String addCustomerButton = ".btn-default";
        String customerSearchBar = "//input[@type='text']";
        String tableLastNameCol = "//table[@class='table table-bordered table-striped']/tbody/tr/td[2]";
        String deleteButton = "//table[@class='table table-bordered table-striped']/tbody/tr/td[5]/button[.='Delete']";
    }
}
