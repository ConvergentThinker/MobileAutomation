package utils;

import com.aventstack.extentreports.MediaEntityBuilder;
import io.appium.java_client.AppiumDriver;
import listeners.ExtentTestManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class StepLogger {

    public static void log(String stepName, AppiumDriver driver) {

        if (driver == null) return;

        try {
            String base64 =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.BASE64);

            ExtentTestManager.getTest().info(
                    stepName,
                    MediaEntityBuilder
                            .createScreenCaptureFromBase64String(base64)
                            .build()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
