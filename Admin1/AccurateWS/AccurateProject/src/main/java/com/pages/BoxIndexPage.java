package com.pages;

import com.controls.ObjectsControl;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoxIndexPage extends ObjectsControl {

    WebDriver driver;
    WebDriverWait wait;
    Scenario scenario;
    String indexPageTitle = "Box — Secure Cloud Content Management, Workflow, and Collaboration";
    String indexPageURL = "https://www.box.com/en-gb/home";
    @FindBy(css="svg#Layer_1.logo-box") WebElement indexLogo;
    @FindBy(xpath="//a[text()='Login']") WebElement indexLoginButton;

    public BoxIndexPage(WebDriver driver, Scenario sc) {
        super(driver, sc);
        this.driver = driver;
        this.scenario = sc;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyIndexPageTitle(){
        return verifyPageTitle(indexPageTitle);
    }

    public boolean verifyUrl(){
        return verifyCurrentURL(indexPageURL);
    }
    public boolean verifyBoxLogo(){
        isPresentAndVisible(indexLogo);
        return true;
    }
    public void clickLogin() throws Exception{click(indexLoginButton);}
}