package com.seb.technicalassessment.utility;

public class BaseTest extends Constants {

    //method to open XYZ bank web app
    public static void setup() {
        DriverManager.getDriver().get(WebConfig.XYZ_BANK_URL);
    }
}
