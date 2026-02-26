package base;

import config.ConfigReader;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilityFactory {

    public static DesiredCapabilities getCapabilities(
            String deviceName,
            String udid,
            String systemPort) {

        DesiredCapabilities caps = new DesiredCapabilities();

        // -------------------------
        // BASIC ANDROID CAPS
        // -------------------------
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("udid", udid);

        // -------------------------
        // APP CONFIGURATION
        // -------------------------
        caps.setCapability("app",
                System.getProperty("user.dir") + "/" + ConfigReader.get("appPath"));

        // -------------------------
        // STABILITY CAPS
        // -------------------------
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("adbExecTimeout", 60000);
        caps.setCapability("appium:appWaitDuration", 10000);
        caps.setCapability("waitForIdleTimeout", 10000);
        caps.setCapability("waitForSelectorTimeout", 10000);

        // -------------------------
        // PARALLEL EXECUTION (CRITICAL)
        // -------------------------
        if (systemPort != null && !systemPort.isEmpty()) {
            caps.setCapability("systemPort", Integer.parseInt(systemPort));
        }

        // -------------------------
        // OPTIONAL BUT GOOD
        // -------------------------
        caps.setCapability("noReset", false);
        caps.setCapability("fullReset", false);

        // Stability for parallel emulators
        caps.setCapability("adbExecTimeout", 120000);
        caps.setCapability("uiautomator2ServerLaunchTimeout", 120000);
        caps.setCapability("uiautomator2ServerInstallTimeout", 120000);
        caps.setCapability("waitForIdleTimeout", 0);
//        caps.setCapability("appWaitDuration", 30000);
        caps.setCapability("appWaitActivity", "*");


        return caps;
    }
}
