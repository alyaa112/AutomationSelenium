package com.seb.technicalassessment.utility;

import org.openqa.selenium.Capabilities;

public class CapabilityFactory {

    public Capabilities capabilities;

    public Capabilities getCapabilities(String browser) {
        if (browser.equals("chrome")) {
            capabilities = OptionsManager.getChromeOptions();
        }
        return capabilities;
    }
}

