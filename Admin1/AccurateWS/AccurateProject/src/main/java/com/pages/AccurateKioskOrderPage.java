package com.pages;

import com.controls.ObjectsControl;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class AccurateKioskOrderPage extends ObjectsControl {
    WebDriver driver;
    WebDriverWait wait;
    Scenario scenario;
    int bookmarkEntryClientCode = (int) (Math.random() * ((1000 - 1) + 1)) + 1;

    @FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$Client_Code']")
    WebElement clientCode;
    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_Contact_0']")
    WebElement contactEmployerCheckBox;
    @FindBy(xpath = "//label[.='International']/preceding-sibling::input[contains(@id,'_ContentPlaceHolder1_PackageGrid_')]")
    WebElement packageOptions;

    @FindBy(xpath = "//th[.='Kiosk Order Information']")
    WebElement kioskOrderInfo;

    @FindBy(xpath = "//input[@value='Start Kiosk']")
    WebElement startKioskButton;
    @FindBy(xpath = "//input[@value='Open Kiosk Form']")
    WebElement openKioskFormButton;

    public AccurateKioskOrderPage(WebDriver driver, Scenario sc) {
        super(driver, sc);
        this.driver = driver;
        this.scenario = sc;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyKioskOrderPage() {
        return verifyPageTitle("Accurate Background -- Kiosk Electronic Release");
    }

    public void setClientCode() {
        clearTypeKeys(clientCode, "QA" + bookmarkEntryClientCode);
    }

    public void fillRequiredDetails(List<Map<String, String>> details) throws Exception {

        for (Map<String, String> row : details) {
            if (row.get("Contact employer").toString().equals("Yes")) {
                click(contactEmployerCheckBox);
            }
            if (row.get("Package Options").toString().equals("International")) {
                click(packageOptions);
            }

            Thread.sleep(1000);
        }
    }

    public boolean verifyStartKioskButton() throws InterruptedException {
        Thread.sleep(2000);
        scrollToElement(startKioskButton);
        return verifyElementByAttribute(startKioskButton, "value", "Start Kiosk");
    }

    public void clickStartKioskButton() throws Exception {
        click(startKioskButton);
    }

    public void clickOpenKioskFormButton() throws Exception {
        click(openKioskFormButton);
    }

}