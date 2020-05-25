@ignore
Feature: Can Customer log in
  Customer should be able to log in

  @ignore
  Scenario: test
    Given Customer log in SalesForce

  #@ignore
  Scenario: Customer has correct credentials
    Given Customer is on Landing page
    When Customer proceed to Login Page
    Then Customer should see Email input
    When Customer enters username as "max-mustermann@example.com"
    And Customer enters password as "123Sonnen!"
    And Customer clicks on login button
    Then Customer should see PV System Name

  @ignore
  Scenario: Customer has incorrect credentials
    Given Customer is on Landing page
    When Customer proceed to Login Page
    Then Customer should see Email input
    When Customer enters username as "!@#$%^&*"
    And Customer enters password as "!@#$%^&*"
    And Customer clicks on login button
    Then Customer is unable to log in

  @ignore
  Scenario: Customer can see his password
    Given Customer is on Landing page
    Given Customer proceed to Login Page
    When Customer should see Email input
    And Customer enters password as "passwd"
    And Customer enables display password feature
    Then Customer can see the password

  @ignore
  Scenario: Customer is able to log out
    Given Customer is on Dashboard page
    When Customer goes to User Menu
    And Customer logs out
    Then Customer should see Email input