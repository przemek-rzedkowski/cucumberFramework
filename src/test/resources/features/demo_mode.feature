#@ignore
Feature: Can Customer experience app without log in
  Customer should be able to experience basic functionalities without having to log in

  #@ignore
  Scenario: Customer goes to demo mode
    Given Customer is on Landing page
    When Customer proceed to Demo mode
    Then Customer sees welcoming page
    When Customer goes to Dashboard Page
    Then Customer sees demo Dashboard page
    When Customer switches to Live State
    Then Customer sees demo Live State
    When Customer shuts down tutorial message
    Then Customer can't see tutorial message
    When Customer switches to Analysis
    Then Customer sees demo Analysis page
    When Customer switches to sonnenCommunity
    Then Customer sees demo sonnenCommunity page
    When Customer switches to sonnenFlat
    Then Customer sees demo sonnenFlat page
    When Customer switches to sonnenBatterie
    Then Customer sees demo sonnenBatterie page
    When Customer leaves Demo mode
    Then Customer should see Email input