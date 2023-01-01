package com.seb.technicalassessment.utility;

import org.openqa.selenium.Capabilities;

public class CapabilityFactory {

    public Capabilities capabilities;

    public Capabilities getCapabilities(String browser) {
        if (browser.equals("chrome"))
            capabilities = (Capabilities) OptionsManager.getChromeOptions();
        else
            System.out.print("No browser");
        return capabilities;
    }
}

