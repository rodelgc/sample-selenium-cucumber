@account @settings
Feature: Change settings
  As a registered user
  I need to go to the Settings page
  So that I can change my Language, Timezone and Password settings.

  #  This will cover the following challenge steps:
  #  2. Input text into a textbox
  #  3. Click button
  Background:
    Given I am logged in

  # This will cover the following challenge step:
  # 1. Select item from pulldown menu
  Scenario Outline:  Change Language and Timezone settings
    Given I am in the Settings page
    When I select the Language "<language_value>"
    And I select the Timezone "<timezone_value>"
    And I submit the Settings form
    Then I see the message
    """
    Language updated
    Timezone updated
    """
    Examples:
      | language_value  | timezone_value          |
      | British English | London, Europe          |
      | U.S. English    | Los Angeles, N. America |



