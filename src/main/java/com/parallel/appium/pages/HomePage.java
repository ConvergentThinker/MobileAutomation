package com.parallel.appium.pages;


import com.parallel.appium.pages.base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HomePage extends BasePage {


    public HomePage(){
        super();
    }

    private By accessibility =
            By.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]");

    public void tapAccessibility() {
        driver.findElement(accessibility).click();
    }
}