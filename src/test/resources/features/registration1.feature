@ignore
Feature: Can Customer sign up
  Customer should be able to register new account

  #@ignore
  Scenario: Customer has correct credentials
    Given Customer proceed to Register Page
    When Customer is on Registration Page
    And Customer uses Correct Credentials to register
    Then Customer is able to proceed to step 2 of registration

  @ignore
  Scenario Outline: Customer has incorrect credentials
    Given Customer proceed to Register Page
    When Customer is on Registration Page
    And Customer "<action>"
    Then Customer can see "<result>"
    Examples:
      |action | result |
      |left Name field blank | lpass |

  #@ignore
  Scenario: Customer has incorrect credentials
    Given Customer proceed to Register Page
    When Customer is on Registration Page
    And Customer leaves all fields blank
    Then Customer sees three error messages
    And Customer cannot submit form due to inactive button
    And Customer leaves Name field blank
    Then Customer sees an error message under name field
    And Customer cannot submit form due to inactive button
    When Customer leaves Last name blank
    Then Customer sees an error message under last name field
    And Customer cannot submit form due to inactive button
    When Customer leaves Mail field blank
    Then Customer sees an error message under email field
    And Customer cannot submit form due to inactive button
    When Customer uses incorrect email format
    Then Customer sees an error message under email field
    And Customer cannot submit form due to inactive button
    When Customer doesn't tick TnC checkbox
    Then Customer sees TnC checkbox's color turned red
    And Customer cannot submit form due to inactive button
    When Customer doesn't tick PP checkbox
    Then Customer sees PP checkbox's color turned red
    And Customer cannot submit form due to inactive button
    When Customer uses email address that already exists in SF
    Then Customer submit form
    And Customer sees message that account already exists