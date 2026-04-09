Feature: New Customer Setup

  @AccountSetup
  Scenario Outline: Account creation with various inputs
    Given the user navigates to the login page
    When User clicks on New Account Button
    And User enters Account details "<FirstName>","<LastName>","<Email>","<Password>","<ConfirmPassword>"
    Then System should display "<outcome>"

    Examples:
      | FirstName | LastName | Email                   | Password      | ConfirmPassword | outcome                                         |
      | Patrick2  | Jane     | patrick42jane@gmail.com | Xsdc#23jane45 | Xsdc#23jane45   | Congratulations! Your account has been created. |
      | Patrick3  | John     | patrick23John@ymail.com | hggffghghh    | hbdegdejdcednb  | The password you re-typed do not match.         |