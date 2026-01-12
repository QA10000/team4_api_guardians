Feature: User Login Controller
    
  Scenario: Successful login
    Given Admin creates request with valid credentials for UserLogin test case "TC01"
    When Admin calls Post Https method with valid endpoint
    Then Admin receives 200 created with auto generated token

  @SkipAuth
  Scenario: Check if admin able to generate token with invalid method
    Given Admin creates request with valid credentials for UserLogin test case "TC01"
    When Admin calls GET Https method with post endpoint
    Then Admin receives 405 method not allowed

  @SkipAuth
  Scenario: Check if admin able to generate token with invalid base URL
    Given Admin creates request with valid credentials for UserLogin test case "TC01"
    When Admin calls Post Https method with invalid base URL
    Then Admin receives 400 bad request

  @SkipAuth
  Scenario: Check if admin able to generate token with invalid credentials
    Given Admin creates request with valid credentials for UserLogin test case "TC01"
    When Admin calls Post Https method with invalid content type
    Then Admin receives 415 unsupported media type	
