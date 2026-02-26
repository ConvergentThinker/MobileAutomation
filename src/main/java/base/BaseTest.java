package base;

import io.appium.java_client.AppiumDriver;
import org.testng.Reporter;
public class BaseTest {

    protected AppiumDriver driver() {
        return DriverManager.getDriver();
    }
    protected void attachDriverToTestNG() {
        Reporter.getCurrentTestResult()
                .setAttribute("driver", DriverManager.getDriver());
    }
}

