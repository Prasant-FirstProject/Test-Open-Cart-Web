Feature: Login page

  As a user of the Open Cart Website
  I want to be able to login with my account
  So that I can access my account related features and manage my orders

Background:
  Given I am on the OpenCart login page

  @Login
  Scenario: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully

  @Login
  Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given I have entered invalid <username> and <password>
    When I click on the login button
    Then I should see an error message indicating <error_message>

    Examples:
    |username|password|error_message|
    |abc@gamil|jsjskks|Warning: No match for E-Mail Address and/or Password.|

  @Login
  Scenario: Navigating to the Forgot password page
    Given I click on the "Forgot Password" link
    Then I should see the Forgot password page