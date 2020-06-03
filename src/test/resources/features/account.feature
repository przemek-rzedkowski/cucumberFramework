#@ignore
Feature: Can Customer change account settings
  Customer should be able to change password and other user settings

  Background:
    Given Customer is logged in as "max-mustermann@example.com"
    When Customer switches to account info
    Then Customer sees Personal Data page

  #@ignore
  Scenario: Customer can see his personal data
    When Customer goes back
    Then Customer should see PV System Name

  #@ignore
  Scenario: Customer can change other settings
    When Customer switches to Settings tab
    Then Customer sees Settings page
    When Customer changes some setting
    Then Customer sees setting's status changed

  #@ignore
  Scenario: Customer is able to change password
    When Customer switches to Password tab
    Then Customer sees change password page
    When Customer fills change password form
    And Customer submits change password form
    Then Customer sees no data in password fields
    And Customer is able to log in using new password

  #@ignore
  Scenario: Customer is unable to change password due to faulty input
    When Customer switches to Password tab
    Then Customer sees change password page
    When Customer types "123Sonnen!" in new password fields
    And Customer submits change password form
    Then Customer sees error message under old password field
    When Customer refreshes site
    And Customer types "123" into old password field
    And Customer submits change password form
    Then Customer sees errors below new password fields