package com.pages;

import com.controls.ObjectsControl;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccurateLoginPage extends ObjectsControl {
    WebDriver driver;
    WebDriverWait wait;
    Scenario scenario;
    @FindBy(xpath = "//input[@name='UserName']")  WebElement userNameField;
    @FindBy(xpath = "//input[@name='Password']")  WebElement passwordField;
    @FindBy(xpath = "//legend[text()='LOGIN']")  WebElement loginPageLabel;
    @FindBy(xpath = "//input[@value='Login']")  WebElement loginButton;

    public AccurateLoginPage(WebDriver driver, Scenario sc) {
        super(driver, sc);
        this.driver = driver;
        this.scenario = sc;
        PageFactory.initElements(driver, this);
    }

    public void verifyLoginPage(){
//        verifyPageTitle(resilixProperties.getProperty("resilixApp.pageTitle"));
        isPresentAndVisible(loginPageLabel);
    }

    public void enterCredentialsAndLogin() throws Exception {
        clearTypeKeys(userNameField,accurateProperties.getProperty("accurate.username"));
        clearTypeKeys(passwordField,accurateProperties.getProperty("accurate.password"));
        click(loginButton);
    }
}
