package Pages;

import base.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HomePage {

    private AppiumDriver driver;

    public HomePage(AppiumDriver driver) {
        this.driver = DriverManager.getDriver();
    }

    private By accessibility =
            By.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]");

    public void tapAccessibility() {
        driver.findElement(accessibility).click();
    }
}

