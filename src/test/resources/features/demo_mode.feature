#@ignore
Feature: Can Customer experience app without log in
  Customer should be able to experience basic functionalities without having to log in

  Background:
    Given Customer is on Landing page
    When Customer proceed to Demo mode
    Then Customer sees welcoming page

  #@ignore
  Scenario: Customer leaves demo mode
    When Customer leaves Demo mode
    Then Customer should see Email input
    When Customer proceed to Demo mode from Login Page
    Then Customer sees welcoming page
    When Customer goes back to registration
    Then Customer is on Registration Page

  #@ignore
  Scenario Outline: Customer goes through demo mode pages
    When Customer switches to "<page>"
    Then Customer sees demo "<page>" page
    When Customer shuts down tutorial message on "<page>"
    Then Customer can't see tutorial message on "<page>"
    Examples:
    |page|
    |Dashboard      |
    |Live State     |
    |Analysis       |
    |sonnenCommunity|
    |sonnenFlat     |
    |sonnenBatterie |