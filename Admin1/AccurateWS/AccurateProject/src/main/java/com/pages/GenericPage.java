package com.pages;

import com.controls.ObjectsControl;
import com.utils.UtilityClass;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericPage extends ObjectsControl {
    WebDriver driver;
    WebDriverWait wait;
    Scenario scenario;

    String allFilesPageTitle = "All Files | Powered by Box";
    public GenericPage(WebDriver driver, Scenario sc) {
        super(driver, sc);
        this.driver = driver;
        this.scenario = sc;
    }

    public void navigateToBoxSite(){
        navigateTo(boxSiteProperties.getProperty("box.url"));
    }

    public void embedScreenshot(String name) {
        scenario.attach(UtilityClass.takeByteScreenshot(driver), "image/png", name);
    }

    public void navigateToBoxApp(){
        navigateTo(boxSiteProperties.getProperty("boxApp.url"));
    }

}
