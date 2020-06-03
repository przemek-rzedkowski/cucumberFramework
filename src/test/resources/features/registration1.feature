#@ignore
Feature: Can Customer sign up (part 1)
  Customer should be able to proceed to step 2 of registration

  Background:
    Given Customer proceed to Register Page
    When Customer is on Registration Page

  #@ignore
  Scenario: Customer is able to clear SF DB and mail inbox for next test run
    Given Customer deletes mails from inbox
    Then Customer sees no mails in inbox
    When Customer is logged into SalesForce
    Then Customer deletes users attached to test accounts

  # alighieri.dante1508+2@gmail.com | Register 2 DO NOT REMOVE
  #@ignore
  Scenario: Customer is able to register with valid email only
    And Customer provides email address that is already in SF
    And Customer submits form
    Then Customer sees successful verification page
    And Customer has a new activation email in his inbox
    Then Customer deletes mails from inbox

  #@ignore
  Scenario: Customer has correct credentials
    And Customer uses correct credentials to register
    Then Customer is able to proceed to step 2 of registration

  #no errors under name and last name fields
  @ignore
  Scenario: Customer provides incorrect credentials
    And Customer leaves all fields blank
    Then Customer sees three error messages
    And Customer cannot submit form due to inactive button
    When Customer uses incorrect email format
    Then Customer sees an error message under email field
    And Customer cannot submit form due to inactive button
    When Customer uses email address that already exists in SF
    Then Customer submits form
    And Customer sees message that account already exists

  #same as above
  @ignore
  Scenario Outline: Customer leaves fields empty
    When Customer leaves "<element>" field blank
    Then Customer sees an error message under "<element>" field
    And Customer cannot submit form due to inactive button
    Examples:
      |element|
      |name|
      |last name|
      |mail|

  #same
  @ignore
  Scenario Outline: Customer does not check required checkboxes
    When Customer doesn't tick "<box>" checkbox
    Then Customer sees "<box>" checkbox's color turned red
    And Customer cannot submit form due to inactive button
    Examples:
      |box|
      |TnC|
      |PP|