#@ignore
Feature: Customer cannot reset password

  Scenario: Customer is unable to use broken token to ones reset password
    Given Customer has an old reset password email in his inbox
    When Customer opens an old email
    And Customer clicks on reset password link
    Then Customer sees new tab opened with something went wrong page
    When Customer selects to go to login page
    Then Customer should see Email input