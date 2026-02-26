package StepDef;

import Pages.HomePage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.*;
import utils.StepLogger;
import base.DriverManager;

public class DemoSteps {

    private AppiumDriver driver;
    private HomePage home;

    public DemoSteps() {
        this.driver = DriverManager.getDriver();
        this.home = new HomePage(driver);
    }

    @Given("app is launched")
    public void app_launched() {
        StepLogger.log("App is launched", driver);
    }

    @When("user taps Accessibility")
    public void tap_accessibility() {
        home.tapAccessibility();
        StepLogger.log("User taps Accessibility", driver);
    }
}


