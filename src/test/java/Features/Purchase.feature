#Automated UI testing using selenium by  Mohammad Junaid
Feature: To Test purchase Functionality

  Background:
    Given User navigates to the login page
    And User Enters the username as "standard_user" and password as "secret_sauce"
    And User clicks on "LoginButton" on "LoginPage"

  @Purchase
  Scenario: Verify that the user can add product to cart from homepage
    Given Validate that login is successful and User is navigated to Homepage
    When User adds "Sauce Labs Backpack" to cart
    Then Validate that the "Sauce Labs Backpack" product is placed in the cart
    And User quits the browser

  @Purchase
  Scenario: Verify that the user can delete product from cart
    Given Validate that login is successful and User is navigated to Homepage
    When User adds "Sauce Labs Backpack" to cart
    Then Validate that the "Sauce Labs Backpack" product is placed in the cart
    When User Removes "Sauce Labs Backpack" from Cart
    Then User validate that the "Sauce Labs Backpack" is removed from th cart
    And User quits the browser

  @Purchase
  Scenario: Verify that the warning is given for unfilled info during checkout
    Given Validate that login is successful and User is navigated to Homepage
    When User adds "Sauce Labs Backpack" to cart
    Then Validate that the "Sauce Labs Backpack" product is placed in the cart
    When User clicks on "CheckoutButton" on "YourCartPage"
    When User clicks on "ContinueButton" on "YourCartPage"
    Then Validate that the warning "Error: First Name is required" is coming
    And User fills "first-name" as "Mohammad" in checkout information
    When User clicks on "ContinueButton" on "YourCartPage"
    Then Validate that the warning "Error: Last Name is required" is coming
    And User fills "last-name" as "Junaid" in checkout information
    When User clicks on "ContinueButton" on "YourCartPage"
    Then Validate that the warning "Error: Postal Code is required" is coming
    And User quits the browser

  @Purchase
  Scenario: Verify that the sorting is working fine for products on homepage
    Given Validate that login is successful and User is navigated to Homepage
    When User selects "Name (Z to A)" from "Sort" dropdown
    Then Validate that all the items are sorted according to "Name (Z to A)"
    When User selects "Name (A to Z)" from "Sort" dropdown
    Then Validate that all the items are sorted according to "Name (A to Z)"
    When User selects "Price (low to high)" from "Sort" dropdown
    Then Validate that all the items are sorted according to "Price (low to high)"
    When User selects "Price (high to low)" from "Sort" dropdown
    Then Validate that all the items are sorted according to "Price (high to low)"
    And User quits the browser


  @Purchase
  Scenario: Full purchase flow of a product
    Given Validate that login is successful and User is navigated to Homepage
    When User adds "Sauce Labs Backpack" to cart
    And User adds "Sauce Labs Bike Light" to cart
    And User adds "Sauce Labs Bolt T-Shirt" to cart
    Then Validate that the "Sauce Labs Backpack" product is placed in the cart
    And Validate that the "Sauce Labs Bike Light" product is placed in the cart
    And Validate that the "Sauce Labs Bolt T-Shirt" product is placed in the cart
    When User Removes "Sauce Labs Backpack" from Cart
    Then User validate that the "Sauce Labs Backpack" is removed from th cart
    When User clicks on "CheckoutButton" on "YourCartPage"
    And User fills "first-name" as "Mohammad" in checkout information
    And User fills "last-name" as "Junaid" in checkout information
    And User fills "postal-code" as "411014" in checkout information
    And User clicks on "ContinueButton" on "YourCartPage"
    Then User Verify checkout overview
    And User clicks on "FinishButton" on "YourCartPage"
    Then Validate that the order is successful
    And User quits the browser















