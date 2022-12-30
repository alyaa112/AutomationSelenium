package com.seb.technicalassessment.utility;

import com.oracle.tools.packager.Log;
import org.openqa.selenium.Capabilities;

public class CapabilityFactory {

    public class CapabilityFactory {

        public Capabilities capabilities;

        public Capabilities getCapabilities(String browser) {
            if (browser.equals("chrome"))
                capabilities = OptionsManager.getChromeOptions();
            else
                Log.info("No browser");
            return capabilities;
        }
    }
}
