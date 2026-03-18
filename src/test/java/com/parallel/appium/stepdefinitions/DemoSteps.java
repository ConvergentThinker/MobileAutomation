package com.parallel.appium.stepdefinitions;


import com.parallel.appium.core.DriverFactory;
import com.parallel.appium.pages.HomePage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.*;
import utils.StepLogger;

public class DemoSteps {

    private HomePage home;

    public DemoSteps(){
        this.home = new HomePage();
    }

    @Given("app is launched")
    public void app_launched() {
        StepLogger.log("App is launched", DriverFactory.getDriver());
    }

    @When("user taps Accessibility")
    public void tap_accessibility() {
        home.tapAccessibility();
        StepLogger.log("User taps Accessibility", DriverFactory.getDriver());
    }
}