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

    # alighieri.dante1508+3@gmail.com ----- for serial number
    # alighieri.dante1508@gmail.com | Register DO NOT REMOVE ------- for customer number
  #@ignore
  Scenario Outline: Customer is able to send activation mail using credentials
    Then Customer switches to "<credentials>" tab
    And Customer uses correct "<credentials>" for step two
    And Customer submits registration form
    Then Customer sees successful verification page
    When Customer selects that he doesn't receive an email
    Then Customer sees troubleshooting message
    And Customer receives confirmation email using "<credentials>"
    Examples:
    |credentials|
    |serial number|
    |customer number|


  #@ignore
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


  #@ignore
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

  #checkboxes are filled also - should they be?
  @ignore
  Scenario: Customer is able go back to first step of registration
    When Customer goes back to first step of registration
    Then Customer sees first step form prefilled with his data

  @ignore
  Scenario: Customer is able to go directly to login page
    When Customer goes to login from second step of registration
    Then Customer should see Email input

  #bugged serial number clue
  @ignore
  Scenario Outline: Customer is able to display location clues
    When Customer switches to "<value>" tab
    And Customer wants to find "<value>"
    Then Customer sees clues about finding "<value>"
    When Customer closes clue page
    Then Customer sees "<value>" tab
    Examples:
    |value|
    |customer number|
    |serial number|

