@ignore
Feature: Customer can sign up (part 2)
  Customer should be able to successfully register new account

  Background:
    Given Customer is on Landing page
    When Customer proceed to Register Page
    Then Customer is on Registration Page
    When Customer uses correct personal data
    And Customer uses email address not found in system
    Then Customer is able to proceed to step 2 of registration

  @ignore
  Scenario Outline: Customer is able to register
    When Customer switches to "<credentials>" tab
    And Customer uses correct "<credentials>" for step two
    And Customer submits registration form
    Then Customer sees successful verification page
    And Customer receives confirmation email
    When Customer selects that he doesn't receive an email
    Then Customer sees troubleshooting message
    Examples:
    |credentials|
    |customer number|
    |serial number|


  @ignore
  Scenario Outline: Customer is unable to register with incorrect serial number or legitimation password
    When Customer uses incorrect serial number and legitimation password
    And Customer submits registration form
    Then Customer sees wrong serial number or password error
    And Customer cannot submit registration form again
    When Customer leaves "<field>" blank
    Then Customer sees error message under "<field>"
    Examples:
    |field|
    |serial number|
    |legitimation password|


  @ignore
  Scenario Outline: Customer is unable to register with incorrect zip code or customer number
    When Customer switches to second way of registration
    And Customer uses incorrect zip code and customer number
    And Customer submits registration form
    Then Customer sees wrong zip code or customer number wrong error
    And Customer cannot submit registration form again
    When Customer leaves "<field>" blank
    Then Customer sees error message under "<field>"
    Examples:
    |field|
    |zip code|
    |customer number|

  @ignore
  Scenario: Customer is able go back to first step of registration
    When Customer goes back to first step of registration
    Then Customer sees first step form prefilled with his data

  @ignore
  Scenario: Customer is able to go directly to login page
    When Customer goes to login from second step of registration
    Then Customer should see Email input

  @ignore
  Scenario Outline: Customer is able to find location clues
    When Customer switches to "<value>" tab
    And Customer wants to find "<value>"
    Then Customer sees clues about finding "<value>"
    When Customer closes clue page
    Then Customer sees "<value>" tab
    Examples:
    |value|
    |serial number|
    |customer number|
