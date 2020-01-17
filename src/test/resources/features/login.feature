@ignore
Feature: Can Customer log in
  Customer should be able to log in

  #@ignore
  Scenario: Customer has correct credentials
    Given Customer proceed to Login Page
    When Customer is on Login Page
    And Customer uses Correct Credentials to log in
    Then Customer is able to log in

  #@ignore
  Scenario: Customer has incorrect credentials
    Given Customer proceed to Login Page
    When Customer is on Login Page
    And Customer uses Incorrect Credentials to log in
    Then Customer is unable to log in

  #@ignore
  Scenario: Customer can see his password
    Given Customer proceed to Login Page
    When Customer is on Login Page
    And Customer enters any password
    And Customer enables display password feature
    Then Customer can see the password

  #@ignore
  Scenario: Customer is able to log out
    Given Customer is on Dashboard page
    When Customer goes to User Menu
    And Customer logs out
    Then Customer is on Login Page