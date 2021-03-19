#Author       :  QAMentor
#Scenario     :  Verify That Client Able To Access KIOSK Release
#Application  :  Accurate
  @kioskstart
Feature: TC1-TC2- Verify That Client Able To work with KIOSK

  Background:
    Given browser is "chrome"
    And user navigates to the Accurate portal

  @kioskrelease @kioskall
  Scenario: TC1- Verify that client able to `access KIOSK release
    When user login to application with valid user details
    And user navigates to Kiosk url
    Then user verifies Kiosk Order page
    When user fills client code
    Then user fills the required details
      | Contact employer | Package Options |
      | Yes              | International   |
    Then user able to see Start Kiosk button

  @kioskforms @kioskall
  Scenario: TC2- Verify that client able to open Kiosk and access all background forms
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
    Then user verifies various background forms on Candidate portal