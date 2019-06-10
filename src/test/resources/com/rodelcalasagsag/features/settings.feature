@settings
Feature: Change settings
  As a registered user
  I need to go to the Settings page
  So that I can change my Language, Timezone and Password settings.

  Background:
    Given I am logged in

  Scenario Outline:  Change Language settings
    When I navigate to the settings page
    And I select the language "<language_value>"
    And I submit the settings form
    Then I should see the message "<success_message>"

    Examples:
      | language_value  | success_message  |
      | British English | Language updated |
      | U.S. English    | Language updated |





