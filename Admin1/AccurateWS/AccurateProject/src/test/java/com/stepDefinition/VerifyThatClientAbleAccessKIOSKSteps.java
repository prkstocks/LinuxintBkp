package com.stepDefinition;

import com.controls.ObjectsControl;
import com.driver.DriverInstance;
import com.pages.*;
import com.utils.UtilityClass;
import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.datatable.DataTable;
import java.util.List;
import java.util.Map;

public class VerifyThatClientAbleAccessKIOSKSteps {
    WebDriver driver;
    WebDriverWait wait;
    static DriverInstance instance;
    AccurateCommonPage cp;
    AccurateLoginPage alp;
    AccurateKioskOrderPage kop;
    AccurateBackgroundFormsPage bfp;

    {
        instance = DriverInstance.getInstance();
        driver = instance.getDriver();
        cp = new AccurateCommonPage(driver, CucumberHooks.scenario);
        alp = new AccurateLoginPage(driver, CucumberHooks.scenario);
        kop = new AccurateKioskOrderPage(driver, CucumberHooks.scenario);
        bfp = new AccurateBackgroundFormsPage(driver, CucumberHooks.scenario);
    }

    @Given("user navigates to the Accurate portal")
    public void userNavigatesToTheAccurateApp() {
        cp.navigateToAccurateHotfixScreen();
    }

    @When("user login to application with valid user details")
    public void userLoginToApplication() throws Exception {
        alp.enterCredentialsAndLogin();
    }

    @And("user navigates to Kiosk url")
    public void userNavigatesToKioskUrl() throws InterruptedException {
        cp.navigateToAccurateKiosk();
        cp.switchToTabWithUrl(ObjectsControl.accurateProperties.getProperty("accurate.kiosk.url"));
    }

    @Then("user verifies Kiosk Order page")
    public void userVerifiesKioskOrderPage() {
        Assert.assertTrue("user unable to verify Kiosk Order Page", kop.verifyKioskOrderPage());
    }

    @When("user fills client code")
    public void userFillsClientCode() {
        kop.setClientCode();
    }

    @Then("user fills the required details")
    public void fillTheRequiredDetails(DataTable requiredDetails) throws Exception {
        List<Map<String,String>> dataList = requiredDetails.asMaps();
        kop.fillRequiredDetails(dataList);
    }

    @Then("user able to see Start Kiosk button")
    public void userAbleToSeeStartKioskButton() throws Exception {
        Assert.assertTrue("User 'unable' to see Start Kiosk button", kop.verifyStartKioskButton());
        CucumberHooks.scenario.log("==> User is successfully able to see Start Kiosk button ");
        CucumberHooks.scenario.attach(UtilityClass.takeByteScreenshot(driver), "image/png", "startkioskBtn");
    }


    @When("user clicks start Kiosk button")
    public void userClicksStartKioskButton() throws Exception {
        kop.clickStartKioskButton();
    }

    @And("user clicks Open Kiosk Form button")
    public void userClicksOpenKioskFormButton() throws Exception {
        kop.clickOpenKioskFormButton();
        cp.switchToTabWithUrl("/Release/KioskStart.aspx");
    }


    @Then("verify background screening can be started")
    public void verifyBackGroundCanStartPage() {
        Assert.assertTrue("user 'unable' to navigated to the background forms", bfp.verifyOnlineBackgroundScreeningReleasePage());
    }


    @When("user clicks on Background screening Start button")
    public void openTheBackgroundFormsByUsingStartKiosk() throws Exception {
        bfp.clickStartButtonBackgroundFormPage();
    }

    @Then("user verifies various background forms on Candidate portal")
    public void verifyBackgroundForms() {
        Assert.assertTrue("user 'unable' to navigated to the background forms", bfp.verifyAccurateAceCandidatePortalPage());
        CucumberHooks.scenario.log("==> user able to navigated to the background forms");
        CucumberHooks.scenario.attach(UtilityClass.takeByteScreenshot(driver), "image/png", "formsCheck");
    }


    @Then("the following list of pages should display within a release")
    public void listOfPagesShouldDisplayWithingARelease(DataTable dataTable) throws Exception {
        List<String> dataList = dataTable.asList(String.class);
        for (String subHeaderName: dataList) {
            if (subHeaderName.contains("Electronic Consent")){
                Assert.assertTrue("user 'unable' to find Electronic Consent", bfp.verifyElectronicConsentHeader());
                CucumberHooks.scenario.log("==> user is successfully 'able' to find Electronic Consent form");
                bfp.checkElectronicConsentCheckBoxes();
                bfp.clickSaveButton();
            }
            if (subHeaderName.contains("Disclosure Regarding Background Investigation")) {
                Assert.assertTrue("user 'unable' to find Disclosure Regarding Background Investigation", bfp.verifyDisclosureRegardingBackgroundInvestigationHeader());
                CucumberHooks.scenario.log("==> user is successfully 'able' to find Disclosure Regarding Background Investigation form");
                bfp.clickIAcknowledgeButton();
//                Assert.assertTrue("user 'unable' to find Custom Page Title", bfp.verifyCustomPageTitleHeader());
                bfp.clickSaveButtonCustomPageTitle();
            }
        }
    }

    @And("user verifies {string} column and fills data as below:")
    public void userVerifiesColumnAndFillsDataAsBelow(String column, DataTable dataTable) throws Exception {
        List<Map<String, String>> dataList = dataTable.asMaps();
        if (column.equals("Personal Information")) {
            bfp.fillPersonalInformation(dataList);
            bfp.clickSaveButtonPersonalInfo();
            CucumberHooks.scenario.log("==> user is successfully 'able' to fill Personal Information form data");
        }
        if (column.equals("Employment History")){
            bfp.fillEnrollmentFormInformation(dataList);
            CucumberHooks.scenario.log("==> user is successfully 'able' to find Employment History form");
        }
        if (column.equals("Education History")){
            bfp.markEducationNoDetails(dataList);
            CucumberHooks.scenario.log("==> All editable fields are successfully disabled on Education History form");
            CucumberHooks.scenario.attach(UtilityClass.takeByteScreenshot(driver), "image/png", "nodetails");
            bfp.saveEducationDetails();
        }
        if (column.equals("Professional License")){
            bfp.noProfessionalLicense(dataList);
        }

    }

    @And("user verifies Criminal History form")
    public void userVerifiesCriminalHistoryForm() {
        Assert.assertTrue("user 'unable' to find Criminal History column", bfp.verifyCriminalHistoryHeader());
        CucumberHooks.scenario.log("==> user is successfully 'able' to find Criminal History form");
        CucumberHooks.scenario.attach(UtilityClass.takeByteScreenshot(driver), "image/png", "criminalForm");
    }


    @And("user verifies {string} column and checks No radio button:")
    public void userVerifiesColumnAndChecksNoRadioButton(String arg0, DataTable dataTable) throws Exception {
        List<Map<String,String>> dataList = dataTable.asMaps();
        bfp.clickCriminalHistoryRadioButton(dataList);
        bfp.clickSaveButtonCriminalHistory();
    }

    @And("user can verify the following employer type in Employment History:")
    public void userCanVerifyTheFollowingEmployerTypeInEmploymentHistory(DataTable dataTable) throws Exception {
        List<String> dataList = dataTable.asList(String.class);
        Assert.assertTrue("user 'cannot' verify the following employer type in Employment History:", bfp.verifyEmployerTypes(dataList));
        CucumberHooks.scenario.log("==> user is successfully 'able' to verify all employer types in Employment History");
        CucumberHooks.scenario.attach(UtilityClass.takeByteScreenshot(driver), "image/png", "empTypes");
    }

    @And("user able to see Timeline gap and select as:")
    public void userAbleToSeeTimelineGapAndSelectAs(DataTable dataTable) throws Exception {
        List<String> dataList = dataTable.asList(String.class);
        bfp.verifyAndSelectTimelineGap(dataList.get(0));
        CucumberHooks.scenario.attach(UtilityClass.takeByteScreenshot(driver), "image/png", "timelineGaps");
        bfp.clickSaveButtonEnrollmentColumn();
        CucumberHooks.scenario.log("==> user is successfully 'able' to verify and select Timeline gap and select as: "+dataList.get(0));

        bfp.submitNoReferencesForm();
    }

    @And("user verifies {string} column and verify school type as:")
    public void userVerifiesColumnAndVerifySchoolTypeAs(String arg0, DataTable dataTable) throws Exception {
        List<String> dataList = dataTable.asList(String.class);
        Assert.assertTrue("user is successfully 'Not able' to verify all 'School Types'", bfp.verifySchoolTypes(dataList));
        CucumberHooks.scenario.log("==> user is successfully 'able' to verify all 'School Types' ");
        CucumberHooks.scenario.attach(UtilityClass.takeByteScreenshot(driver), "image/png", "educationTypes");
    }

    @When("user reads and acknowledges FCRA consent form")
    public void userReadsAndAcknowledgesFCRAConsentForm() throws Exception {
        bfp.scrollNoticeCityApplicantToEnd();
        bfp.clickAcknowledgeButton();
        bfp.fcraConsentForm();
        CucumberHooks.scenario.log("==> user is successfully 'able' to read and acknowledges FCRA consent form ");
    }

    @And("user provides following details on background check and authorize:")
    public void userProvidesSignatureOnBackgroundCheckAndAuthorize(DataTable dataTable) throws Exception {
        List<Map<String, String>> dataList = dataTable.asMaps();
        bfp.clickElectronicSignManualEntry();
        bfp.signatureAndBackgroundCheckForm(dataList);
        CucumberHooks.scenario.attach(UtilityClass.takeByteScreenshot(driver), "image/png", "finalauthorize");
        bfp.clickAuthorizeButtonBackgroundCheck();
        CucumberHooks.scenario.log("==> user has successfully provided details on background check and authorized:");

    }

    @Then("user should be asked to confirm SSN details popup")
    public void userShouldBeAskedToConfirmSSNDetails() throws Exception {
        bfp.clickSsnCheckboxBackGround();
        boolean confirmSsn = bfp.verifyConfirmSsnButton();
        Assert.assertTrue("user could not find SSN pop-up", confirmSsn);
        CucumberHooks.scenario.log("==> user is successfully 'able' to confirm SSN pop-up: "+confirmSsn);
        CucumberHooks.scenario.attach(UtilityClass.takeByteScreenshot(driver), "image/png", "ssnPopup");
    }


    @When("user save the confirm ssn popup")
    public void userSaveTheConfirmSsnPopup() throws Exception {
        bfp.clickConfirmSsnPopupButton();
    }

    @Then("user verify {string} popup and download documents")
    public void userVerifyPopupAndDownloadDocuments(String arg0) throws Exception {
        bfp.verifyFinishDialog();
        Assert.assertTrue("All the  documents are not downloaded in the zip file", bfp.downloadFormsAndCheckSize());
        CucumberHooks.scenario.log("==> All the documents are downloaded successfully in zip file ");
        CucumberHooks.scenario.attach(UtilityClass.takeByteScreenshot(driver), "image/png", "filesDownloaded");
    }
}
