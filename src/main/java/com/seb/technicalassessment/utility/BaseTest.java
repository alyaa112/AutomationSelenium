package com.seb.technicalassessment.utility;

import java.sql.DriverManager;

public class BaseTest extends Constants {

    //method to open XYZ bank web app
    public static void launchXYZBankWebapp() {
        DriverManager.getDriver().get(WebConfig.XYZ_BANK_URL);
    }
}
