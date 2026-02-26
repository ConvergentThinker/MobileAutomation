package hooks;

import base.DriverManager;
import base.TestContext;
import base.CapabilityFactory;
import config.ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.Reporter;

import java.net.URL;
import java.time.Duration;

public class AppHooks {

    @Before
    public void setUp() throws Exception {

        String port = TestContext.getPort();

        if (port == null) {
            throw new RuntimeException("Device details not set for this thread");
        }

        AppiumDriver driver = new AndroidDriver(
                new URL("http://127.0.0.1:" + port),
                CapabilityFactory.getCapabilities(
                        TestContext.getDeviceName(),
                        TestContext.getUdid(),
                        TestContext.getSystemPort()
                )
        );

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(
                        ConfigReader.getInt("implicitWait")
                ));

        // ✅ Set driver in ThreadLocal
        DriverManager.setDriver(driver);

        // ✅ THIS IS THE KEY LINE (DO NOT MISS)
        Reporter.getCurrentTestResult()
                .setAttribute("driver", driver);
    }

    @After
    public void tearDown() {

        AppiumDriver driver = DriverManager.getDriver();

        if (driver != null) {
            try {
                driver.quit();
            } finally {
                DriverManager.unload();
                TestContext.clear();
            }
        }
    }
}
