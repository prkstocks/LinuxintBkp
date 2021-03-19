package com.pages;

import com.controls.ObjectsControl;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoxLoginPage extends ObjectsControl {
    WebDriver driver;
    WebDriverWait wait;
    Scenario scenario;
    String loginPageTitle = "Box | Login";
    String loginPageURL ="https://account.box.com/login";
    @FindBy(xpath="//input[@name='login']") WebElement loginTxtBox;
    @FindBy(xpath="//button[@id='login-submit']") WebElement loginNextButton;
    @FindBy(xpath="//input[@id='password-login']") WebElement passwdTxtBox;
    @FindBy(xpath="//button[@id='login-submit-password']") WebElement loginButton;

    public BoxLoginPage(WebDriver driver, Scenario sc) {
        super(driver, sc);
        this.driver = driver;
        this.scenario = sc;
        PageFactory.initElements(driver, this);
    }

    public void verifyLoginScreen(){
        String textValue;
        verifyPageTitle(loginPageTitle);
        verifyCurrentURL(loginPageURL);
    }

    public void enterLoginCredentials() throws Exception{
        clearTypeKeys(loginTxtBox,boxSiteProperties.getProperty("box.email"));
        click(loginNextButton);
        clearTypeKeys(passwdTxtBox, boxSiteProperties.getProperty("box.password"));
        click(loginButton);
    }

}