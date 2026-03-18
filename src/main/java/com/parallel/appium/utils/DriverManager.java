package com.parallel.appium.utils;


import com.parallel.appium.core.DriverFactory;
import io.appium.java_client.AppiumDriver;

public class DriverManager {


    public static AppiumDriver getDriver() {
        return DriverFactory.getDriver().get();
    }

    public static void setDriver(AppiumDriver driverInstance) {
        DriverFactory.getDriver().set(driverInstance);
    }

    public static void unload() {
        DriverFactory.getDriver().remove();
    }
}