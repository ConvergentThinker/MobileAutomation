
package TestRunner;

import base.TestContext;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"StepDef", "hooks"},
        plugin = {"pretty",
                "summary",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class TestRunnerAppium extends AbstractTestNGCucumberTests {

    @BeforeClass(alwaysRun = true)
    @Parameters({"deviceName", "udid", "port", "systemPort"})
    public void setDeviceDetails(String deviceName,
                                 String udid,
                                 String port,
                                 String systemPort) {

        TestContext.set(deviceName, udid, port, systemPort);

    }
}


