#Automated UI testing using selenium by  Mohammad Junaid
Feature: To Test Login Functionality



  Scenario: 1. Verify Login logout functionality for a valid User
    Given User navigates to the login page
    And User Enters the username as "standard_user" and password as "secret_sauce"
    And clicks on "LoginButton" on "LoginPage"
    Then Validate that login is successful and User is navigated to Homepage
    When User selects "Logout" from "MenuButton"
    Then Validate that user has logged out successfully

  Scenario: 2. Verify Login is locked for a locked user
    Given User navigates to the login page
    And User Enters the username as "locked_out_user" and password as "secret_sauce"
    And clicks on "LoginButton" on "LoginPage"
    Then Validate that login is unsuccessful and warning message is displayed





