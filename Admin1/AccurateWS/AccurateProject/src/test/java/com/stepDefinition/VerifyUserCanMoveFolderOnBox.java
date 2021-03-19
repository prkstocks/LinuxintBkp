package com.stepDefinition;

import com.driver.DriverInstance;
import com.pages.BoxAllFilesPage;
import com.pages.BoxIndexPage;
import com.pages.BoxLoginPage;
import com.pages.GenericPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class VerifyUserCanMoveFolderOnBox {
    WebDriver driver;
    WebDriverWait wait;
    static DriverInstance instance;

    BoxIndexPage bip;
    BoxLoginPage blp;
    GenericPage gp;
    BoxAllFilesPage afp;

    {
        instance = DriverInstance.getInstance();
        driver = instance.getDriver();
        gp = new GenericPage(driver, CucumberHooks.scenario);
        bip = new BoxIndexPage(driver, CucumberHooks.scenario);
        blp = new BoxLoginPage(driver, CucumberHooks.scenario);
        afp = new BoxAllFilesPage(driver, CucumberHooks.scenario);
    }

    @Given("user navigates to box url")
    public void userOpensBoxSite(){
        gp.navigateToBoxSite();
    }

    @When("user verifies home page")
    public void verifyIndexScreen(){
        Assert.assertTrue("URL is not valid", bip.verifyUrl());
        Assert.assertTrue("Page Title is not valid", bip.verifyIndexPageTitle());
        Assert.assertTrue("Box Logo is not displayed", bip.verifyBoxLogo());
    }

    @Then("user navigates to login screen")
    public void navigateToLoginScreen() throws Exception{
        bip.clickLogin();
    }

    @And("user verifies the login screen")
    public void verifyLoginScreen(){
        blp.verifyLoginScreen();
    }

    @When("user enter login credentials")
    public void enterLoginCredentials() throws Exception{
        blp.enterLoginCredentials();
    }

    @Then("user verifies the All files screen")
    public void verifyAllFilesPage() throws Exception {
        Assert.assertTrue("Page Header is not valid", afp.verifyAllFilesHeader());
        Assert.assertTrue("Page Title is not valid", afp.verifyAllFilesPageTitle());
    }

    @Then("user logs out")
    public void userLogout() throws Exception {
        afp.verifyAllFilesHeader();
        afp.userLogout();
    }

    @And("user navigates to box App")
    public void navigateToBoxApp(){
        gp.navigateToBoxApp();
    }

    @And("user navigates to create new folder")
    public void createNewFolder() throws Exception {
        afp.selectCreateFolder();
    }

    @When("user fills the required information")
    public void createRequiredData() throws Exception {
        afp.selectCreateFolder();
    }

    @Then("verify the creaete new popup")
    public void verifyCreateFolderPopup(){
        afp.verifyNewFolderPopup();
    }

    @And("user enters the required valid information")
    public void enterValidFolderData(DataTable folderData) throws Exception {
        List<Map<String,String>> folderDataList = folderData.asMaps();
        afp.enterRequiredFolderData(folderDataList);
    }

    @When("user clicks the Create button")
    public void clickToCreate() throws Exception{
        afp.clickCreateButton();
    }

    @And("user verifies success message for folder {string}")
    public void verifyFolderCreated(String act){
        afp.verifyCreateSuccessMsg(act);
    }
    @Then("user deletes newly created Folder")
    public void deleteNewFolderAndVerify() throws Exception {
        afp.selectNewFolder();
        afp.deleteCreatedFolder();
    }
}
