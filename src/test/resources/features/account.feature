@ignore
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
  #check salesforce part also
Scenario: Customer can change other settings
  When Customer switches to Settings tab
  Then Customer sees Settings page
  When Customer changes some setting
  Then Customer sees setting's status changed