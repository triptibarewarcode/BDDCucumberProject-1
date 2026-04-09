Feature: Login Functionality
  As a registered user
  I want to log into the application
  So that I can access my dashboard

  @Login @Positive @Negative
  Scenario Outline: Validate login with different credentials
    Given the user navigates to the login page
    When the user enters username "<username>"
    And the user enters password "<password>"
    And the user clicks on the login button
    Then the system should display "<expected_result>"

    Examples:
      | username              | password      | expected_result |
      | patrickjane@gmail.com | Xsdc#23jane45 | dashboard       |