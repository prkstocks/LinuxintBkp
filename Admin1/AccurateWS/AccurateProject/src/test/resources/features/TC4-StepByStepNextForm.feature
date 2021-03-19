#Author       :  QAMentor
#Scenario     :  Verify That Client Able To Access KIOSK Release
#Application  :  Accurate
Feature: TC4- Verify that user able to  move on next form step by step

  Background:
    Given browser is "chrome"
    And user navigates to the Accurate portal

  @stepBystep @kioskall
  Scenario: TC4- Verify that user able to  move on next form step by step
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

    And user verifies Criminal History form