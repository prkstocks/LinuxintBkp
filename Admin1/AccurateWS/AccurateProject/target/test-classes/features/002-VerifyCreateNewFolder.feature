#Author       :  QAMentor
#Scenario     :  Verify that user able to login Box application
#Application  :  app.Box.com

@kioskstart
Feature:002-Verify user able to login to box app

  Background:
    Given browser is "chrome"
    And user navigates to box App

  @boxcreateFolder @boxall
  Scenario: 002a - verify user able to create new folder in Box
    And user verifies the login screen
    When user enter login credentials
    When user navigates to create new folder
    Then verify the creaete new popup
    And user enters the required valid information
      | Folder Name | Invite Additional People  | Permission  |
      | gobiFolds   | gobizado@gmail.com        | Editor      |
    When user clicks the Create button
    Then user verifies success message for folder "creation"
    When user deletes newly created Folder
    Then user verifies success message for folder "deletion"

     # Then user logs out
