#Author       :  QAMentor
#Scenario     :  Verify That Client Able To Access KIOSK Release
#Application  :  Accurate
Feature: TC7- Verify that user able to see education details

  Background:
    Given browser is "chrome"
    And user navigates to the Accurate portal

  @seeEducation @kioskall
  Scenario: TC7- Verify that user able to see education details
    When user login to application with valid user details
    And user navigates to Kiosk url
    Then user verifies Kiosk Order page
    When user fills client code
    Then user fills the required details
      | Contact employer | Package Options |
      | Yes              | International   |
    Then user able to see Start Kiosk button
    When user clicks start Kiosk button
    And user clicks Open Kiosk Form button
    Then verify background screening can be started
    When user clicks on Background screening Start button
    Then the following list of pages should display within a release
      | Electronic Consent                            |
      | Disclosure Regarding Background Investigation |
    And user verifies "Personal Information" column and fills data as below:
      | FirstName | MiddleName | LastName | CertifyName | DOB        | Phone      | Email                | NoDrivingLicense | SSN         | ConfirmSSN  | Street   | City     | State    | ZipCode | StartDate | AppliedState |
      | QAMentor  | QA         | Coverage | Yes         | 02/02/1996 | 9982229992 | support@qamentor.com | Yes              | 121 11 1111 | 121 11 1111 | 22Bakers | New York | New York | 10018   | 02/2020   | New York     |

    And user verifies "Criminal History" column and checks No radio button:
      | CriminalHistory |
      | No              |
    And user verifies "Employment History" column and fills data as below:
      | CompanyName | StartDate | EndDate | Street   | City     | State    | Zip   | Phone      | Supervisor | YourPosition | Wage  | WageIncrement | RelatedToCurrEmployer | DotRegulatedEmp | DotSafety |
      | Yahoo       | 01/2011   | 07/2015 | 22Bakers | New York | New York | 10018 | 9998887766 | Ruslan     | QAEngineer   | $2000 | Semi-Monthly  | No                    | Yes             | Yes       |
    And user able to see Timeline gap and select as:
      | Relocation |
    And user verifies "Education History" column and verify school type as:
      | High School/GED      |
      | College/University   |
      | Vocational/Technical |
      | Trade/Business       |
