package com.seb.technicalassessment.utility;

import java.time.Duration;

public class BaseTest extends Constants {

    //method to open XYZ bank web app
    public static void setup() throws InterruptedException {
        System.out.print("Thread id = " + Thread.currentThread().getId());
        System.out.print("Hashcode of web driver instance = " + DriverManager.getDriver().hashCode());
        DriverManager.getDriver().get(WebConfig.XYZ_BANK_URL);
    }
}
