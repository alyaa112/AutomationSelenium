package com.seb.technicalassessment.utility;

public class Constants {

    public class WebConfig {
        public static final String XYZ_BANK_URL = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
        public static final String NODE_URL = "http://localhost:4444/wd/hub";
        public static final String WINDOW_START_STATE = "--start-maximized";
        public static final String WEB_PAGE_STATE = "return document.readyState";
        public static final String WEB_PAGE_STATUS = "complete";
        public static final String EXECUTION_MODE = "headless";
    }

    public class CommonDetails {
        public static final int BANK_MANAGER_OPTION = 1;
        public static final int FIRST_NAME_TEXTFIELD = 0;
        public static final int LAST_NAME_TEXTFIELD = 1;
        public static final int POSTCODE_TEXTFIELD = 2;
    }

    public class ChromeConfigurations {
        public static final String CERTIFICATE_ERROR = "--ignore-certificate-errors";
        public static final String POP_UP_DISABLE = "--disable-popup-blocking";
        public static final String WINDOW_SIZE = "--window-size=1920,1080";
        public static final String SANDBOX_FLAG = "no-sandbox";
        public static final String NOTIFICATION_DISABLE = "--disable-notifications";
        public static final String USER_AGENT = "--user-agent=Chrome/77.0.3865.90"; //need to change according to your local chrome version
    }
}
