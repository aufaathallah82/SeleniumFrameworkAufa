Feature: Login

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters username "standard_user" and password "secret_sauce"
    And the user clicks the login button
    Then the user should see the products page
