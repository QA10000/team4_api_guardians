Feature: Login
    Check if admin able to generate token with valid credential

  Scenario: Successful login
    Given Admin creates request with valid credentials
    When Admin calls Post Https method  with valid endpoint
    Then Admin receives 201 created with auto generated token

    		
