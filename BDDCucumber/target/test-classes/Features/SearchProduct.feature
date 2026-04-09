Feature: Search Products

  @Search
  Scenario: Search for a valid product
    Given the user is on the Kapruka homepage
    When the user searches for "eggless vanilla cake"
    Then the results page should show products