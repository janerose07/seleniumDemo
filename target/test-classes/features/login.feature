Feature: Login Functionality

  Scenario: Successful login with valid credentials
    Given user is on the login page
    When user enters username "standard_user" and password "secret_sauce"
    And user clicks on login button
    Then user should be navigated to home page
    And welcome message should be displayed

  Scenario Outline: Unsuccessful login with invalid credentials
    Given user is on the login page
    When user enters username "<username>" and password "<password>"
    And user clicks on login button
    Then error message should be displayed

    Examples:
      | username | password    |
      | invalid  | password123 |
      | testuser | wrong       |
      |          | password123 |
      | testuser |             |