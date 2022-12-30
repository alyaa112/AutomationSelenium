package com.seb.technicalassessment.utility;

public class OptionsManager extends Constants {

    //Get Chrome Options
    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(WebConfig.WINDOW_START_STATE);
        options.addArguments(ChromeConfigurations.SANDBOX_FLAG);
        options.addArguments(WebConfig.EXECUTION_MODE);
        options.addArguments(ChromeConfigurations.CERTIFICATE_ERROR);
        options.addArguments(ChromeConfigurations.POP_UP_DISABLE);
        options.addArguments(ChromeConfigurations.WINDOW_SIZE);
        options.addArguments(ChromeConfigurations.NOTIFICATION_DISABLE);
        options.addArguments(ChromeConfigurations.USER_AGENT);
        return options;
    }
}
