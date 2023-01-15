#Automated UI testing using selenium by  Mohammad Junaid
Feature: To Test purchase Functionality

  Background:
    Given User navigates to the login page
    And User Enters the username as "standard_user" and password as "secret_sauce"
    And clicks on "LoginButton" on "LoginPage"


  Scenario: Verify the full flow of purchasing a product
    Given Validate that login is successful and User is navigated to Homepage



