#Author       :  QAMentor
#Scenario     :  Verify that user able to launch BoxSite
#Application  :  app.Box.com

@kioskstart
Feature:001-Verify Box Site Index Page

  Background:
    Given browser is "chrome"

  @boxindexBox @boxall
  Scenario: 001- Verify that user able to launch Box Site
    When user navigates to box url
    Then user verifies home page
    When user navigates to login screen
    And user enter login credentials
    When user verifies the All files screen
    Then user logs out

  @boxAppLogin @boxall
  Scenario: 002 - verify user directly access box app login page
    And user navigates to box App
    When user verifies the login screen
    And user enter login credentials
    When user verifies the All files screen
    Then user logs out