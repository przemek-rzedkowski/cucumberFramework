@ignore
Feature: Customer can reset ones password
  Customer should be able reset password for his account

  Background:
    Given Customer is on Landing page
    When Customer proceed to Login Page
    Then Customer should see Email input
    When Customer selects that he forgot the password
    Then Customer sees forgot password page
    When Customer inserts his email address to reset
    And Customer submits forgot password form
    Then Customer sees sending successful page


  #@ignore
  Scenario: Customer is unable to reset password due to faulty input
    Given Customer has an reset password email in his inbox
    When Customer opens email
    And Customer clicks on reset password link
    Then Customer sees new tab opened with reset password page
    When Customer leaves both fields blank
    Then Customer cannot submit reset password form
    And Customer sees errors below fields
    When Customer provides password as "123" to reset password fields
    Then Customer sees an error under new password field
    And Customer sees that he fulfill number restriction
    When Customer provides password as "!@#$$%^^&&%$#" to reset password fields
    Then Customer sees an error under new password field
    And Customer sees that he fulfill special signs and length restriction
    When Customer provides password as "123Sonnen!" to new password field
    And Customer provides password as "123Sonnen?" to confirm password field
    Then Customer sees error stating that password don't match
    And Customer cannot submit reset password form


  #@ignore
  Scenario: Customer is able to reset password
    Given Customer has an reset password email in his inbox
    When Customer opens email
    And Customer clicks on reset password link
    Then Customer sees new tab opened with reset password page
    When Customer provides password as "123Sonnen!" to reset password fields
    Then Customer sees all three restrictions fulfilled
    When Customer clicks on eye icons
    Then Customer sees passwords as "123Sonnen!"
    When Customer submits reset password form
    Then Customer sees reset password confirmation page
    When Customer selects to go proceed to login page
    Then Customer should see Email input
    When Customer provides credentials as "alighieri.dante1508@gmail.com" and "123Sonnen!"
    And Customer clicks on login button
    Then Customer should see PV System Name

