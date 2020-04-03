#@ignore
Feature: Customer can finalize sign up process and use repeatedly same credentials
  Customer should be able to log in after successful registration

  # alighieri.dante1508+1@gmail.com | Register 1 DO NOT REMOVE
  #@ignore
  Scenario: Customer is unable to set up password for new account due to lack of input
    Given Customer has an activation email in his inbox
    When Customer uses token from activation email
    Then Customer sees new tab opened with setting password page
    When Customer leaves both fields blank
    Then Customer cannot submit password form
    When Customer leaves new password field blank
    Then Customer cannot submit password form
    And Customer sees error message under new password field
    When Customer leaves confirm password field blank
    Then Customer cannot submit password form
    And Customer sees error message under confirm password field


  @ignore
  Scenario: Customer is unable to set up password for new account due to faulty input
    Given Customer has an activation email in his inbox
    When Customer uses token from activation email
    Then Customer sees new tab opened with setting password page
    When Customer provides password as "123" to both password fields
    Then Customer cannot submit password form
    When Customer provides password as "123Sonnen" to both password fields
    And Customer checks only terms and conditions checkbox
    Then Customer cannot submit password form
    When Customer checks only privacy policy checkbox
    Then Customer cannot submit password form
    When Customer checks and unchecks both checkboxes
    Then Customer cannot submit password form
    And Customer sees both checkboxes' names in red


  @ignore
  Scenario: Customer is unable to set up password for new account due to broken token
    Given Customer has an activation email in his inbox
    When Customer uses broken token from activation email
    Then Customer sees new tab opened with resend invitation page
    When Customer inserts his email address to resend
    And Customer submits resend invitation form
    Then Customer has a new activation email in his inbox

  @ignore
  Scenario: Customer is able to set up password for new account
    Given Customer has an activation email in his inbox
    When Customer uses token from activation email
    Then Customer sees new tab opened with setting password page
    When Customer provides new password
    Then Customer sees password complexity frame
    When Customer confirms password
    And Customer checks checkboxes
    And Customer submits password form
    Then Customer sees registration completed page
    When Customer selects to log in immediately
    Then Customer should see Email input

  @ignore
  Scenario: Customer is able to sign in to newly created account
    Given Customer is on Landing page
    When Customer proceed to Login Page
    Then Customer should see Email input
    When Customer enters username as "alighieri.dante1508+1@gmail.com"
    And Customer enters password as "123Sonnen!"
    And Customer clicks on login button
    Then Customer should see PV System Name

  @ignore
  Scenario: Customer is able to clear SF DB for next test run
    Given Customer is logged into SalesForce
    When Customer deletes user created via email registration
    Then Customer sees no user attached to "Register 2 DO NOT REMOVE" account
    When Customer deletes user created via customer number
    Then Customer sees no user attached to "Register 1 DO NOT REMOVE" account
    When Customer deletes "Dante Alighieri" account
    And Customer reattaches test battery to "+++ ASSET COLLECT ACCOUNT + DO NOT RENAME +++" account
    Then Customer see test battery as ready to be attached again
    #also remove mails from inbox