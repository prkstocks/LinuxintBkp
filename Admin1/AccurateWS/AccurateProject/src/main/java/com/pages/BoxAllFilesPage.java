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

public class BoxAllFilesPage extends ObjectsControl {
    WebDriver driver;
    WebDriverWait wait;
    Scenario scenario;
    String allFilesPageTitle = "All Files | Powered by Box";
    String dropDownValue1 = "Folder";
    @FindBy(xpath="//h1[text()='All Files']") WebElement allFilesHeader;
    //@FindBy(xpath="//*[@class='arrow-down-illustration']") WebElement chatBotArrow;
    @FindBy(xpath="//div[@class='OnboardingTrackerPopout-header-svgWrap']") WebElement chatBotArrow;
    @FindBy(xpath="//button[@class='btn create-dropdown-menu-toggle-button']") WebElement newDropDown;
    @FindBy(xpath="//li[@aria-label='Create a new Folder']") WebElement selectFolder;

    @FindBy(xpath="//span[@class='avatar-initials ']") WebElement profileButton;
    @FindBy(xpath="//span[text()='Log Out']") WebElement logoutMenu;

    @FindBy(xpath="//h2[@class='modal-title']") WebElement popupTitle;
    @FindBy(xpath="//input[@name='folder-name']") WebElement folderNameTxtBox;
    @FindBy(xpath="//textarea[@class='bdl-PillSelector-input pill-selector-input bdl-PillSelector-input--showAvatars']") WebElement inviteTxtBox;
    @FindBy(xpath="//select[@name='invite-permission']") WebElement permissionDropDown;
    @FindBy(xpath="//button[@data-resin-target='primarybutton']") WebElement createButton;
    @FindBy(xpath="//*[contains(text(),'was created successfully')]") WebElement createSuccessMsg;
    @FindBy(xpath="//div[starts-with(@class, 'ReactVirtualized__Table__row') and @data-item-index='0']") WebElement newFolder;
    @FindBy(xpath="//button[@aria-label='Trash']") WebElement trashIcon;
    @FindBy(xpath="//span[text()='Okay']") WebElement okPopupButton;
    @FindBy(xpath="//*[contains(text(),'Item successfully moved to trash.')]") WebElement deleteSuccessMsg;


    public BoxAllFilesPage(WebDriver driver, Scenario sc) {
        super(driver, sc);
        this.driver = driver;
        this.scenario = sc;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyAllFilesPageTitle() throws Exception {
        verifyPageTitle(allFilesPageTitle);
        //click(chatBotArrow);
        return true;
    }

    public boolean verifyAllFilesHeader(){
        isPresentAndVisible(allFilesHeader);
        return true;
    }

    public void selectCreateFolder() throws Exception {
        click(newDropDown);
        click(selectFolder);
    }

    public void verifyNewFolderPopup(){
        //verifyElementByTextMatches(popupTitle, "Create a New Folder");
        //isVisible(popupTitle);
        verifyElementByText(permissionDropDown, "Editor");
    }

    public void enterRequiredFolderData(List<Map<String, String>> folderData) throws Exception {
        for (Map<String, String> row : folderData) {
                clearTypeKeys(folderNameTxtBox, row.get("Folder Name"));
                clearTypeKeys(inviteTxtBox, row.get("Invite Additional People"));
                selectDropDownVisibleText(permissionDropDown,row.get("Permission"));
        }
            Thread.sleep(1000);
    }

    public void clickCreateButton() throws Exception {
        click(createButton);
    }

    public void verifyCreateSuccessMsg(String act){
        if(act.equals("creation"))
            isPresentAndVisible(createSuccessMsg);
        if(act.equals("deletion"))
            isPresentAndVisible(deleteSuccessMsg);
    }

    public void selectNewFolder() throws Exception {
        isPresentAndVisible(newFolder);
        click(newFolder);
    }

    public void deleteCreatedFolder() throws Exception {
        click(trashIcon);
        click(okPopupButton);
    }

    public void userLogout() throws Exception{
        refreshPage();
        Thread.sleep(5000);
        click(profileButton);
        click(logoutMenu);
    }
}