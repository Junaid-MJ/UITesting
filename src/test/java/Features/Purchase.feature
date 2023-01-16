#Automated UI testing using selenium by  Mohammad Junaid
Feature: To Test purchase Functionality

  Background:
    Given User navigates to the login page
    And User Enters the username as "standard_user" and password as "secret_sauce"
    And User clicks on "LoginButton" on "LoginPage"


  Scenario: Verify that the user can add product to cart from hompage
    Given Validate that login is successful and User is navigated to Homepage
    When User adds "Sauce Labs Backpack" to cart
    Then Validate that the "Sauce Labs Backpack" product is placed in the cart
    And User quits the browser

  Scenario: Verify that the user can delete product from cart
    Given Validate that login is successful and User is navigated to Homepage
    When User adds "Sauce Labs Backpack" to cart
    Then Validate that the "Sauce Labs Backpack" product is placed in the cart
    When User clicks on "RemoveButton" on "YourCartPage"
    Then User validate that the "Sauce Labs Backpack" is removed from th cart
    And User quits the browser

  Scenario: Full purchase flow of a product





