@ignore
Feature: Can Customer change account settings
  Customer should be able to change password and other user settings

Background:
  Given Customer is logged in
  When Customer switches to account info
  Then Customer sees Personal Data page

#@ignore
Scenario: Customer can see his personal data
  When Customer goes back
  Then Customer is on Dashboard page

#@ignore
Scenario: Customer can change his password
  When Customer switches to password tab
  Then Customer sees Password page
  When Customer fills changing password form with new password
  And Customer confirms change
  Then Customer cannot see confirmation banner
  When Customer logs out
  Then Customer is able to log in using new password
  And Customer changes password to default one

#@ignore
Scenario: Customer can change other settings
  When Customer switches Settings tab
  Then Customer sees Settings page
  When Customer changes some setting
  Then Customer sees setting's status changed