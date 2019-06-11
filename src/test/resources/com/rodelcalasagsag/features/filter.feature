@markets
Feature: Filter Markets
  As a trader
  I need to have a way to filter currencies in the Markets page
  So that I can trade in those selected currencies

  Background:
    Given I am in the Markets page

  Scenario: Filter by Asset
    When I select the following assets and quotes:
      | assets | quotes |
      | ETH    | USD    |
      | BTC    | EUR    |
      |        | GBP    |
    Then I should see the table being filtered by asset:
      | asset-codes | asset-names | quote-codes |
      | ETH         | Ethereum    | USD         |
      | BTC         | Bitcoin     | EUR         |
      |             |             | GBP         |