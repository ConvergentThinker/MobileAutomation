package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

public class ExtentTestNGListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

        String udid = result.getTestContext()
                .getCurrentXmlTest()
                .getParameter("udid");

        ExtentReports extent = ExtentManager.getExtent(udid);

        ExtentTest test = extent.createTest(
                result.getMethod().getMethodName()
        );

        ExtentTestManager.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTestManager.getTest().fail(result.getThrowable());

        Object driverObj = result.getAttribute("driver");
        if (driverObj instanceof AppiumDriver) {

            String base64 =
                    ((TakesScreenshot) driverObj)
                            .getScreenshotAs(OutputType.BASE64);

            ExtentTestManager.getTest().fail(
                    "Failure Screenshot",
                    MediaEntityBuilder
                            .createScreenCaptureFromBase64String(base64)
                            .build()
            );
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.flush();
        ExtentTestManager.removeTest();
    }
}



//package listeners;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import io.appium.java_client.AppiumDriver;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//public class ExtentTestNGListener implements ITestListener {
//
//    @Override
//    public void onTestStart(ITestResult result) {
//
//        // Get UDID from testng.xml
//        String udid = result.getTestContext()
//                .getCurrentXmlTest()
//                .getParameter("udid");
//
//        ExtentReports extent = ExtentManager.getExtent(udid);
//
//        ExtentTest extentTest = extent.createTest(
//                result.getMethod().getMethodName()
//        );
//
//        ExtentTestManager.setTest(extentTest);
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        captureScreenshot(result, "Test Passed");
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        ExtentTestManager.getTest().fail(result.getThrowable());
//        captureScreenshot(result, "Test Failed");
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        ExtentTestManager.getTest().skip("Test Skipped");
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        ExtentManager.flush();
//    }
//
//    // ================= HELPER METHOD =================
//
//    private void captureScreenshot(ITestResult result, String message) {
//
//        try {
//            Object driverObject = result.getAttribute("driver");
//
//            if (driverObject instanceof AppiumDriver) {
//
//                AppiumDriver driver = (AppiumDriver) driverObject;
//
//                String base64 =
//                        ((TakesScreenshot) driver)
//                                .getScreenshotAs(OutputType.BASE64);
//
//                ExtentTestManager.getTest().info(
//                        message,
//                        MediaEntityBuilder
//                                .createScreenCaptureFromBase64String(base64)
//                                .build()
//                );
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//
