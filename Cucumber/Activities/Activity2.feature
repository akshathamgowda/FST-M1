@Activity2
Feature: Login Test

Scenario: Testing Login
    Given User is on Login page
    When User enters username and password
    Then Read the page title and confirmation message
    And Close the Browser@Activity1
Feature: Basic Syntax

Scenario: Opening a webpage using Selenium
    Given User is on Google Home Page
    When User types in Cheese and hits ENTER
    Then Show how many search results were shown