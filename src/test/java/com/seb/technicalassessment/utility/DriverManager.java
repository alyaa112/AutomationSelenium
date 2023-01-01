package com.seb.technicalassessment.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager implements IInvokedMethodListener {
    private static final ThreadLocal<RemoteWebDriver> remoteWebDriver = new ThreadLocal<>();
    public final CapabilityFactory capabilityFactory = new CapabilityFactory();

    public static synchronized WebDriver getDriver() {
        return remoteWebDriver.get();
    }

    public static synchronized void setDriver(RemoteWebDriver driver) {
        remoteWebDriver.set(driver);
    }

    @Parameters(value = {"browser"})
    private void createInstance(String browser) throws MalformedURLException {
        setDriver(new RemoteWebDriver(new URL(Constants.WebConfig.NODE_URL), capabilityFactory.getCapabilities(browser)));
    }

    //To instantiate webdriver in the beginning of every run
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browser");
            try {
                createInstance(browserName);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    //To close browser after each run
    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            RemoteWebDriver remoteDriver = (RemoteWebDriver) getDriver();
            if (remoteDriver != null) {
                remoteDriver.quit();
                remoteWebDriver.remove();
            }
        }
    }
}