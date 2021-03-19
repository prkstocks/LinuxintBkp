package com.pages;

import com.controls.ObjectsControl;
import io.cucumber.java.Scenario;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;
import java.util.Map;

public class AccurateBackgroundFormsPage extends ObjectsControl{
    WebDriver driver;
    WebDriverWait wait;
    Scenario scenario;


    @FindBy(xpath = "//input[@value='START »']") WebElement startButtonBackgroundFormPage;

    @FindBy(xpath = "//h2[.='Electronic Consent']") WebElement electronicConsentHeader;
    @FindBy(xpath = "//div[contains(@class,'ConsentDTO_ESignature')]/div/p[5]") WebElement electronicConsentLastPara;

    @FindBy(xpath = "//h2[.='Disclosure Regarding Background Investigation']") WebElement disclosureRegardingBackgroundInvestigationHeader;
    @FindBy(xpath = "//div[contains(@class,'ConsentDTO_Disclosure')]/div/p[3]") WebElement dRBILastPara;

    @FindBy(xpath = "//h2[.='Custom Page Title']") WebElement customPageTitleHeader;
    @FindBy(xpath = "//h2[.='Criminal History']") WebElement criminalHistoryHeader;

    @FindBy(xpath = "//span[contains(.,'I have read and understand the above statement')]") WebElement firstCheckBoxEC;
    @FindBy(xpath = "//span[contains(.,'I consent and agree to all of the above and to electronically')]") WebElement secondCheckBoxEC;

    @FindBy(xpath = "//button[@id='disabledSaveButton']/span[text()='Save']") WebElement saveButton;
    @FindBy(xpath = "//button[@id='disabledSaveButton']/span[text()='I Acknowledge']") WebElement iAcknowledgeButton;
    @FindBy(xpath = "//button/span[.='Save']") WebElement saveButtonCustomPageTitle;


    @FindBy(xpath = "(//input[@formcontrolname='firstName'])[1]") WebElement firstName;
    @FindBy(xpath = "(//input[@formcontrolname='lastName'])[1]") WebElement lastName;
    @FindBy(xpath = "(//input[@formcontrolname='middleName'])[1]") WebElement middleName;
    @FindBy(xpath = "//mat-checkbox[@formcontrolname='noMiddleName']/label/div/input") WebElement noMiddleNameChechBox;
    @FindBy(xpath = "(//div[@class='mat-checkbox-inner-container'])[2]") WebElement certifyLegalNameCheckBox;
    @FindBy(xpath = "//div[@class='personal-information-grid3'] //input[@placeholder='MM/DD/YYYY']") WebElement dateOfBirth;
    @FindBy(xpath = "//input[@formcontrolname='phoneNumber']") WebElement phoneNumber;
    @FindBy(xpath = "//input[@type='email']") WebElement email;
    @FindBy(xpath = "(//input[@placeholder='###'])[1]") WebElement ssnPart1;
    @FindBy(xpath = "(//input[@placeholder='##'])[1]") WebElement ssnPart2;
    @FindBy(xpath = "(//input[@placeholder='####'])[1]") WebElement ssnPart3;

    @FindBy(xpath = "(//input[@placeholder='###'])[2]") WebElement reSsnPart1;
    @FindBy(xpath = "(//input[@placeholder='##'])[2]") WebElement reSsnPart2;
    @FindBy(xpath = "(//input[@placeholder='####'])[2]") WebElement reSsnPart3;

    @FindBy(xpath = "//span[@class='mat-select-placeholder ng-tns-c14-65 ng-star-inserted']") WebElement selectDLState;
    @FindBy(xpath = "(//div[@class='mat-checkbox-inner-container'])[3]") WebElement noDrivingLicense;
    @FindBy(xpath = "//input[@formcontrolname='streetAddressLineOne']") WebElement streetAddress;
    @FindBy(xpath = "//input[@formcontrolname='city']") WebElement city;
    @FindBy(xpath = "//mat-select[@formcontrolname='state']/div/div/span") WebElement stateClick;
    @FindBy(xpath = "//span[.=' New York ']") WebElement stateSelect;
    @FindBy(xpath = "//input[@formcontrolname='zip']") WebElement zipCode;
    @FindBy(xpath = "//input[@formcontrolname='from']") WebElement startDate;
    @FindBy(xpath = "//mat-select[@formcontrolname='stateApplyingToWorkIn'] /div/div/span") WebElement appliedStateClick;
    @FindBy(xpath = "//span[.=' New York ']") WebElement appliedStateSelect;

    @FindBy(xpath = "//button[@class='saveButton mat-flat-button']") WebElement saveButtonPersonalInfo;

    @FindBy(xpath = "(//label[@class='mat-radio-label']//div[contains(.,'No')])[1]") WebElement criminalHistoryRadioNO;
    @FindBy(xpath = "(//button[@class='saveButton mat-flat-button']/span)[2]") WebElement saveButtonCriminalHistory;


    @FindBy(xpath = "//input[@placeholder='Company Name']") WebElement companyName;
    @FindBy(xpath = "//input[@formcontrolname='startDate']") WebElement startDateEnrollment;
    @FindBy(xpath = "//input[@formcontrolname='endDate']") WebElement endDateEnrollment;
    @FindBy(xpath = "(//input[@formcontrolname='streetAddressLineOne'])[2]") WebElement streetAddressEnrollment;
    @FindBy(xpath = "(//input[@formcontrolname='city'])[2]") WebElement cityEnrollment;
    @FindBy(xpath = "(//mat-select[@formcontrolname='state']/div/div/span)[2]") WebElement stateClickEnrollment;
    @FindBy(xpath = "//span[.=' New Jersey ']") WebElement stateSelectEnrollment;
    @FindBy(xpath = "(//input[@formcontrolname='zip'])[2]") WebElement zipCodeEnrollment;
    @FindBy(xpath = "(//input[@formcontrolname='phoneNumber'])[2]") WebElement phoneEnrollment;
    @FindBy(xpath = "//input[@formcontrolname='supervisorName']") WebElement supervisorName;
    @FindBy(xpath = "//input[@formcontrolname='positionName']") WebElement positionName;
    @FindBy(xpath = "//input[@formcontrolname='wage']") WebElement wageEnrollment;
    @FindBy(xpath = "//mat-select[@formcontrolname='wageIncrement']/div/div/span") WebElement wageIncrementClick;
    @FindBy(xpath = "//span[.='Semi-Monthly ']") WebElement wageIncrementSelect;

    @FindBy(xpath = "(//label[@class='mat-radio-label'] //div[contains(.,'No')])[1]") WebElement currentEmployerNO;
    @FindBy(xpath = "(//label[@class='mat-radio-label'] //div[contains(.,'No')])[2]") WebElement dotRegulatedEmpyoyerNO;
    @FindBy(xpath = "(//label[@class='mat-radio-label'] //div[contains(.,'No')])[3]") WebElement dotSafetyRadioNO;

    @FindBy(xpath = "(//label[@class='mat-radio-label'] //div[contains(.,'Yes')])[1]") WebElement currentEmployerYES;
    @FindBy(xpath = "(//label[@class='mat-radio-label'] //div[contains(.,'Yes')])[2]") WebElement dotRegulatedEmpyoyerYES;
    @FindBy(xpath = "(//label[@class='mat-radio-label'] //div[contains(.,'Yes')])[3]") WebElement dotSafetyRadioYES;

    @FindBy(xpath = "(//button[@class='saveButton mat-flat-button']/span)[2]") WebElement saveButtonEnrollment;

    @FindBy(xpath = "//mat-select[@formcontrolname='employerType']") WebElement employerTypeColumn;
    @FindBy(xpath = "//span[.='Temporary/Contract Employment ']") WebElement temporaryContractEmployment;
    @FindBy(xpath = "//span[.='Self Employment']") WebElement selfEmployment;
    @FindBy(xpath = "//span[.='Volunteer/Unpaid Internship']") WebElement volunteerUnpaidInternship;
    @FindBy(xpath = "//span[.='Military Service']") WebElement militaryService;
    @FindBy(xpath = "//span[.='Non-US Employment']") WebElement nonUSEmployment;
    @FindBy(xpath = "//span[.='Standard US Employment ']") WebElement standardUSEmployment;

    @FindBy(css = "mat-select[formcontrolname='gapReason'] span[class*=mat-select-placeholder]") WebElement employeeGapSelect;
    @FindBy(xpath = "//span[contains(.,'Relocation')]") WebElement relocationEmployeeGapType;

    @FindBy(xpath = "//span[@class='mat-checkbox-label'][contains(text(),'references')]") WebElement noReferencesCheckbox;
    @FindBy(xpath = "(//button[contains(@class,'saveButton mat-flat-button')]/span[.='Save'])[2]") WebElement saveButtonRefForm;

    @FindBy(xpath = "(//mat-select[@formcontrolname='schoolType'])[1]") WebElement schoolTypeColumn;
    @FindBy(xpath = "//span[contains(.,'High School/GED')]") WebElement highSchoolGedOption;
    @FindBy(xpath = "//span[contains(.,'College/University')]") WebElement collegeuniversityOption;
    @FindBy(xpath = "//span[contains(.,'Vocational/Technical')]") WebElement vocationalTechnicalOption;
    @FindBy(xpath = "//span[contains(.,'Trade/Business')]") WebElement tradeBusinessOption;

    @FindBy(xpath = "//span[contains(.,'I have not graduated')]") WebElement notGraduatedCheckbox;
    @FindBy(xpath = "//button[@class='confirmButton ng-star-inserted']") WebElement notGradConfirmationButton;

    @FindBy(xpath = "//mat-checkbox[@formcontrolname='hasNoLicenses']/label/span") WebElement noProfLicenseCertification;

    @FindBy(xpath = "//div[@class='ConsentDTO_NyArticle23a content-area']/div/center") WebElement noticeFormCityApplicants;
    @FindBy(xpath = "//span[.='I Acknowledge']") WebElement acknowledgeButtonNoticeForm;

    @FindBy(xpath = "//div[@class='ConsentDTO_SummaryOfRights content-area'] //strong[text()='A Summary of Your Rights Under the Fair Credit Reporting Act']") WebElement summaryOfRights;

    @FindBy(xpath = "//div[@id='sigContainer']/a[@class='manual']") WebElement electronicSignManualEntry;

    @FindBy(xpath = "//div[@class='manual-consent']//input[@formcontrolname='firstName']") WebElement firstNameManualESign;
    @FindBy(xpath = "//div[@class='manual-consent']//input[@formcontrolname='lastName']") WebElement lastNameManualESign;
    @FindBy(xpath = "//div[@class='manual-consent']//input[@formcontrolname='last4SSN']") WebElement last4DigitsSsn;
    @FindBy(xpath = "//mat-checkbox[@formcontrolname='isAuthorized']/label/span[@class]") WebElement iAcceptCheckbox;

    @FindBy(xpath = "//button[contains(@class,'Authorize')]/span[.='Authorize']") WebElement authorizeButtonBackgroundCheck;
    @FindBy(css="div#scrollArea x#START_PARAGRAPH") WebElement acknowledgeParagraph;

    @FindBy(xpath = "//mat-checkbox[@formcontrolname='isSocialSecurityNumberConfirmed']/label/div[@class]") WebElement ssnCheckboxBackground;
    @FindBy(xpath = "//button[contains(@class,'saveButton')]/span[.='Confirm']") WebElement confirmButtonSsn;

    @FindBy(xpath="//div[@class='mat-dialog-content']//h1[contains(text(),' Done')]") WebElement finishDialogLabel;
    @FindBy(xpath = "//button/span[.=' Download Forms ']") WebElement downloadFormsbutton;
    @FindBy(xpath = "//a/span[.='Finish']") WebElement finishButton;

    public AccurateBackgroundFormsPage(WebDriver driver, Scenario sc) {
        super(driver, sc);
        this.driver = driver;
        this.scenario = sc;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyOnlineBackgroundScreeningReleasePage(){
        return verifyPageTitle("Online Background Screening Release");
    }

    public boolean verifyAccurateAceCandidatePortalPage(){
        return verifyPageTitle("AccurateAce Candidate Portal");
    }
    public void clickStartButtonBackgroundFormPage() throws Exception {
        click(startButtonBackgroundFormPage);
    }

    public boolean verifyElectronicConsentHeader(){
        return verifyElementByText(electronicConsentHeader, "Electronic Consent");
    }

    public void checkElectronicConsentCheckBoxes() throws Exception {
        scrollToElement(electronicConsentLastPara);
        click(firstCheckBoxEC);
        click(secondCheckBoxEC);
    }

    public void clickSaveButton() throws Exception {
        click(saveButton);
    }

    public void clickIAcknowledgeButton() throws Exception {
        scrollToElement(dRBILastPara);
        click(iAcknowledgeButton);
    }

    public boolean verifyDisclosureRegardingBackgroundInvestigationHeader() {
        return verifyElementByText(disclosureRegardingBackgroundInvestigationHeader, "Disclosure Regarding Background Investigation");
    }

    public boolean verifyCustomPageTitleHeader(){
        return verifyElementByText(customPageTitleHeader, "Custom Page Title");
    }

    public void clickSaveButtonCustomPageTitle() throws Exception {
        click(saveButtonCustomPageTitle);
    }

    public void fillPersonalInformation(List<Map<String, String>> dataTable) throws Exception {
        for (Map<String, String> row  : dataTable) {
            clearTypeKeys(firstName, row.get("FirstName"));
            clearTypeKeys(middleName, row.get("MiddleName"));
            clearTypeKeys(lastName, row.get("LastName"));
            if (row.get("CertifyName").equals("Yes")){
                scrollToElement(certifyLegalNameCheckBox);
                click(certifyLegalNameCheckBox);
            }
            clearTypeKeys(dateOfBirth, row.get("DOB"));
            clearTypeKeys(phoneNumber, row.get("Phone"));
            clearTypeKeys(email, row.get("Email"));
            if (row.get("NoDrivingLicense").equals("Yes")){
                click(noDrivingLicense);
            }
            String[] ssn = row.get("SSN").split("\\s");
            String ssn1 = ssn[0];
            String ssn2 = ssn[1];
            String ssn3 = ssn[2];
            clearTypeKeys(ssnPart1, ssn1);
            clearTypeKeys(ssnPart2, ssn2);
            clearTypeKeys(ssnPart3, ssn3);
            clearTypeKeys(reSsnPart1, ssn1);
            clearTypeKeys(reSsnPart2, ssn2);
            clearTypeKeys(reSsnPart3, ssn3);
            clearTypeKeys(streetAddress, row.get("Street"));
            clearTypeKeys(city, row.get("City"));
            if (row.get("State").equals("New York")) {
                click(stateClick);
                Thread.sleep(1000);
                scrollToElement(stateSelect);
                click(stateSelect);
            }
            clearTypeKeys(zipCode, row.get("ZipCode"));
            clearTypeKeys(startDate, row.get("StartDate"));
            if (row.get("AppliedState").equals("New York")){
                click(appliedStateClick);
                Thread.sleep(1000);
                scrollToElement(appliedStateSelect);
                click(appliedStateSelect);
            }
        }
    }

    public void clickSaveButtonPersonalInfo() throws Exception {
        click(saveButtonPersonalInfo);
    }

    public boolean verifyCriminalHistoryHeader(){
       return verifyElementByText(criminalHistoryHeader, "Criminal History");
    }

    public void clickCriminalHistoryRadioButton(List<Map<String, String>> dataTable) throws Exception {
        verifyCriminalHistoryHeader();
        for (Map<String, String> row : dataTable){
            if (row.get("CriminalHistory").equals("No")){
                scrollToElement(criminalHistoryRadioNO);
                click(criminalHistoryRadioNO);
            }
        }
    }

    public void clickSaveButtonCriminalHistory() throws Exception {
        scrollToElement(saveButtonCriminalHistory);
        click(saveButtonCriminalHistory);
    }

    public void fillEnrollmentFormInformation(List<Map<String, String>> dataTable) throws Exception {
        for (Map<String, String> row  : dataTable) {
            clearTypeKeys(companyName, row.get("CompanyName"));
            clearTypeKeys(startDateEnrollment, row.get("StartDate"));
            clearTypeKeys(endDateEnrollment, row.get("EndDate"));
            clearTypeKeys(streetAddressEnrollment, row.get("Street"));
            clearTypeKeys(cityEnrollment, row.get("City"));
            if (row.get("State").equals("New York")){
                click(stateClickEnrollment);
                Thread.sleep(1000);
                scrollToElement(stateSelectEnrollment);
                click(stateSelectEnrollment);
            }
            clearTypeKeys(zipCodeEnrollment, row.get("Zip"));
            clearTypeKeys(phoneEnrollment, row.get("Phone"));
            clearTypeKeys(supervisorName, row.get("Supervisor"));
            clearTypeKeys(positionName, row.get("YourPosition"));
            clearTypeKeys(wageEnrollment, row.get("Wage"));
            if (row.get("WageIncrement").equals("Semi-Monthly")){
                click(wageIncrementClick);
                Thread.sleep(1000);
                scrollToElement(wageIncrementSelect);
                click(wageIncrementSelect);
            }
            if (row.get("RelatedToCurrEmployer").equals("No")){
                click(currentEmployerNO);
            }
            if (row.get("DotRegulatedEmp").equals("Yes")){
                click(dotRegulatedEmpyoyerYES);
            }
            if (row.get("DotSafety").equals("Yes")){
                click(dotSafetyRadioYES);
            }
        }
    }

    public void clickSaveButtonEnrollmentColumn() throws Exception {
        click(saveButtonEnrollment);
    }

    public boolean verifyEmployerTypes(List<String> dataList) throws Exception {
        click(employerTypeColumn);
        if (dataList.contains("Standard US Employment"))
            verifyElementByText(standardUSEmployment, "Standard US Employment");
        if (dataList.contains("Temporary/Contract Employment"))
            verifyElementByText(temporaryContractEmployment, "Temporary/Contract Employment");
        if (dataList.contains("Self Employment"))
            verifyElementByText(selfEmployment, "Self Employment");
        if (dataList.contains("Volunteer/Unpaid Internship"))
            verifyElementByText(volunteerUnpaidInternship, "Volunteer/Unpaid Internship");
        if (dataList.contains("Military Service"))
            verifyElementByText(militaryService, "Military Service");
        if (dataList.contains("Non-US Employment"))
            verifyElementByText(nonUSEmployment, "Non-US Employment");
                return true;
    }

    public void verifyAndSelectTimelineGap(String selection) throws Exception {
        click(employeeGapSelect);
        if (selection.equals("Relocation")) {
            scrollToElement(relocationEmployeeGapType);
            click(relocationEmployeeGapType);
        }
    }

    public void submitNoReferencesForm() throws Exception {
        click(noReferencesCheckbox);
        click(saveButtonRefForm);
    }

    public boolean verifySchoolTypes(List<String> dataList) throws Exception {
        click(schoolTypeColumn);
        if (dataList.contains("High School/GED"))
            verifyElementByText(highSchoolGedOption, "High School/GED");
        if (dataList.contains("College/University"))
            verifyElementByText(collegeuniversityOption, "College/University");
        if (dataList.contains("Vocational/Technical"))
            verifyElementByText(vocationalTechnicalOption, "Vocational/Technical");
        if (dataList.contains("Trade/Business"))
            verifyElementByText(tradeBusinessOption, "Trade/Business");
        return true;
    }

    public void markEducationNoDetails(List<Map<String, String>> dataList) throws Exception {
        for (Map<String, String> row  : dataList) {
            if (row.get("NotGraduated").equals("Yes")){
                click(notGraduatedCheckbox);
                click(notGradConfirmationButton);

            }
        }
    }

    public void saveEducationDetails() throws Exception {
        click(saveButtonRefForm);
    }

    public void noProfessionalLicense(List<Map<String, String>> dataList) throws Exception {
        for (Map<String, String> row  : dataList) {
            if (row.get("NoLicenses").equals("Yes")) {
                click(noProfLicenseCertification);
                click(notGradConfirmationButton);
                click(saveButtonRefForm);
            }
            }
    }

    public void scrollNoticeCityApplicantToEnd() throws Exception {
        scrollToPageBottom();
        click(noticeFormCityApplicants);
        sendModifierKeys(Keys.END);
    }

    public void clickAcknowledgeButton() throws Exception {
        Thread.sleep(2000);
        scrollToElement(acknowledgeButtonNoticeForm);
        click(acknowledgeButtonNoticeForm);
    }

    public void fcraConsentForm() throws Exception {
        click(summaryOfRights);
        sendModifierKeys(Keys.END);
        Thread.sleep(2000);
        scrollToElement(acknowledgeButtonNoticeForm);
        click(acknowledgeButtonNoticeForm);
    }

    public void clickElectronicSignManualEntry() throws Exception {
        click(electronicSignManualEntry);
    }

    public void signatureAndBackgroundCheckForm(List<Map<String, String>> dataList) throws Exception {
        click(acknowledgeParagraph);
        sendModifierKeys(Keys.END);
        for (Map<String, String> row  : dataList) {
            clearTypeKeys(firstNameManualESign, row.get("First Name"));
            clearTypeKeys(lastNameManualESign, row.get("Last Name"));
            clearTypeKeys(last4DigitsSsn, row.get("Last 4 Digits of SSN"));
        }
        click(iAcceptCheckbox);
    }

    public void clickAuthorizeButtonBackgroundCheck() throws Exception {
        scrollToElement(authorizeButtonBackgroundCheck);
        click(authorizeButtonBackgroundCheck);
    }

    public void clickSsnCheckboxBackGround() throws Exception {
        click(ssnCheckboxBackground);
    }

    public boolean verifyConfirmSsnButton(){
       return verifyElementByText(confirmButtonSsn, "Confirm");
    }

    public void clickConfirmSsnPopupButton() throws Exception {
        click(confirmButtonSsn);
    }

    public void verifyFinishDialog(){
        verifyElementByText(finishDialogLabel,"Done!");
    }

    public boolean downloadFormsAndCheckSize() throws Exception {
        click(downloadFormsbutton);
        Thread.sleep(10000);
        boolean present = false;
        File file = new File(System.getProperty("user.dir")+"\\downloads\\documents.zip");
        if (file.exists() && file.isFile()) {
            double fileSize = file.length() / 1024;

            if (file.getName().contains(".zip") && fileSize>100)
                present = true;
            else
                present=false;
            file.delete();
        }

        return present;
    }

}