Feature: User Login Controller


#  Scenario: Check if admin able to generate token with valid credential
#    Given Admin creates request with valid credentials for UserLogin test case "TC01"
#    When Admin calls Post Https method with valid endpoint
#    Then Admin receives 200 created with auto generated token


#  Scenario: Check if admin able to generate token with invalid method
#    Given Admin creates request with valid credentials for UserLogin test case "TC02"
#    When Admin calls GET Https method with post endpoint
#    Then Admin receives 405 method not allowed
#
#
#  Scenario: Check if admin able to generate token with invalid base URL
#    Given Admin creates request with valid credentials for UserLogin test case "TC03"
#    When Admin calls Post Https method with invalid base URL
#    Then Admin receives 400 bad request
#
#
#  Scenario: Check if admin able to generate token with invalid content type
#    Given Admin creates request with valid credentials for UserLogin test case "TC04"
#    When Admin calls Post Https method with invalid content type
#    Then Admin receives 415 unsupported media type
#
#  Scenario: Check if admin able to generate token with invalid endpoint
#    Given Admin creates request with valid credentials UserLogin test case "TC05"
#    When Admin calls Post Https method with invalid endpoint
#    Then Admin receives 401 unauthorized
#
#  Scenario: Check if admin able to generate token with special characters in admin email
#    Given Admin creates request with special characters in admin email UserLogin test case "TC06"
#    When Admin calls Post Https method with valid endpoint
#    Then Admin receives 401 with message "Bad Credentials" and false success message
#
#  Scenario: Check if admin able to generate token with special characters in password
#    Given Admin creates request with special characters in password UserLogin test case "TC07"
#    When Admin calls Post Https method with valid endpoint
#    Then Admin receives 401 with message "Bad Credentials" and false success message
#
#  Scenario: Check if admin able to generate token with number in email
#    Given Admin creates request with numbers in email UserLogin test case "TC08"
#    When Admin calls Post Https method with valid endpoint
#    Then Admin receives 401 with message "Bad Credentials" and false success message
#
#  Scenario: Check if admin able to generate token with numbers in password
#    Given Admin creates request with numbers in password UserLogin test case "TC09"
#    When Admin calls Post Https method with valid endpoint
#    Then Admin receives 401 with message "Bad Credentials" and false success message
#
#  Scenario: Check if admin able to generate token with Null password
#    Given Admin creates request with Null password UserLogin test case "TC10"
#    When Admin calls Post Https method with valid endpoint
#    Then Admin receives 401 with message "Password is Mandatory" and false success message
#
#  Scenario: Check if admin able to generate token with Null Email
#    Given Admin creates request with Null email UserLogin test case "TC11"
#    When Admin calls Post Https method with valid endpoint
#    Then Admin receives 401 with message "Email Id is Mandatory" and false success message
#
#  Scenario: Check if admin able to generate token with Null body
#    Given Admin creates request with Null body UserLogin test case "TC12"
#    When Admin calls Post Https method with valid endpoint and null body
#    Then Admin receives 400 Bad request
#
## FORGOT PASSWORD
#
#  # Scenario: Check if admin able to generate token with valid credentials
#  #   Given Admin creates request with valid credentials for UserLogin test case "TC10"
#  #   When Admin calls POST Https method with valid endpoint
#  #   Then Admin receives 200 created with auto generated token
#
#  Scenario: Check if admin able to generate token with invalid email
#    Given Admin creates request with invalid credentials for UserLogin test case "TC13"
#    When Admin calls POST Https method with valid endpoint
#    Then Admin receives 401 with message "Email Id is Mandatory"
#
#  Scenario: Check if admin able to generate token with special characters in email
#    Given Admin creates request with special character email for UserLogin test case "TC14"
#    When Admin calls POST Https method with valid endpoint
#    Then Admin receives 400 bad request
#
#  Scenario: Check if admin able to generate token with invalid endpoint
#    Given Admin creates request with valid credentials for UserLogin test case "TC15"
#    When Admin calls POST Https method with invalid endpoint
#    Then Admin receives 404 not found
#
#  Scenario: Check if admin able to generate token with null request body
#    Given Admin creates request with null body for UserLogin test case "TC16"
#    When Admin calls POST Https method with valid endpoint
#    Then Admin receives 401 with message "Email Id is Mandatory"
#
#  Scenario: Check if admin able to generate token with invalid content type
#    Given Admin creates request with valid credentials for UserLogin test case "TC17"
#    When Admin calls POST Https method with invalid content type
#    Then Admin receives 415 unsupported media type