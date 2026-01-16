Feature: User Login Controller

  Rule: No Auth

    Background: Admin sets no Authorization to Bearer Token.
      Given admin sets no Authorization to Bearer Token

    Scenario: Check if admin able to generate token with invalid method
      Given Admin creates request with valid credentials for UserLogin test case "TC02"
      When Admin calls GET Https method with post endpoint
      Then Admin receives 405 method not allowed

    Scenario: Check if admin able to generate token with invalid base URL
      Given Admin creates request with valid credentials for UserLogin test case "TC03"
      When Admin calls Post Https method with invalid base URL
      Then Admin receives 400 bad request for invalid baseUrl

    Scenario: Check if admin able to generate token with invalid content type
      Given Admin creates request with valid credentials for UserLogin test case "TC04"
      When Admin calls Post Https method with invalid content type
      Then Admin receives 415 unsupported media type

    Scenario: Check if admin able to generate token with invalid endpoint
      Given Admin creates request with valid credentials UserLogin test case "TC05"
      When Admin calls Post Https method with invalid endpoint
      Then Admin receives 401 unauthorized

    Scenario: Check if admin able to generate token with special characters in admin email
      Given Admin creates request with special characters in admin email UserLogin test case "TC06"
      When Admin calls Post Https method with valid endpoint
      Then Admin receives 400 with message "Active User with given email Id Not Found" and false success message

    Scenario: Check if admin able to generate token with special characters in password
      Given Admin creates request with special characters in password UserLogin test case "TC07"
      When Admin calls Post Https method with valid endpoint
      Then Admin receives 401 with message "Bad credentials" and false success message

    Scenario: Check if admin able to generate token with number in email
      Given Admin creates request with numbers in email UserLogin test case "TC08"
      When Admin calls Post Https method with valid endpoint
      Then Admin receives 400 with message "Active User with given email Id Not Found" and false success message

    Scenario: Check if admin able to generate token with numbers in password
      Given Admin creates request with numbers in password UserLogin test case "TC09"
      When Admin calls Post Https method with valid endpoint
      Then Admin receives 400 with message "password must contain atleast 8 to max 32 characters, a capital letter, a small letter, a special character, a number and no space" and false success message

    Scenario: Check if admin able to generate token with Null password
      Given Admin creates request with Null password UserLogin test case "TC10"
      When Admin calls Post Https method with valid endpoint
      Then Admin receives 400 with message "Password is mandatory" and false success message

    Scenario: Check if admin able to generate token with Null Email
      Given Admin creates request with Null email UserLogin test case "TC11"
      When Admin calls Post Https method with valid endpoint
      Then Admin receives 400 with message "EmailId is mandatory" and false success message

    Scenario: Check if admin able to generate token with Null body
      Given Admin creates request with Null body UserLogin test case "TC12"
      When Admin calls Post Https method with valid endpoint and null body
      Then Admin receives 400 Bad request
# # FORGOT PASSWORD

#     # Scenario: Check if admin able to generate token with valid credentials
#     #   Given Admin creates request with valid credentials for UserLogin test case "TC13"
#     #   When Admin calls POST Https method for forgot password with valid endpoint
#     #   Then Admin receives 200 created with auto generated token

    Scenario: Check if admin able to generate token with invalid email
      Given Admin creates request with invalid credentials for UserLogin test case "TC14"
      When Admin calls POST Https method for forgot password with valid endpoint
      Then Admin receives 400 bad request

    Scenario: Check if admin able to generate token with special characters in email
      Given Admin creates request with special character email for UserLogin test case "TC15"
      When Admin calls POST Https method for forgot password with valid endpoint
      Then Admin receives 400 bad request

    Scenario: Check if admin able to generate token with invalid endpoint
      Given Admin creates request with valid credentials for UserLogin test case "TC16"
      When Admin calls POST Https method for forgot password with invalid endpoint
      Then Admin receives 404 not found

    Scenario: Check if admin able to generate token with null request body
      Given Admin creates request with null body for UserLogin test case "TC17"
      When Admin calls POST Https method for forgot password with valid endpoint
      Then Admin receives 400 with message "Email[Id is m]andatory"

    Scenario: Check if admin able to generate token with invalid content type
      Given Admin creates request with valid credentials for UserLogin test case "TC18"
      When Admin calls POST Https method forgot passwordwith invalid content type
      Then Admin receives 415 unsupported media type

# #LOGOUT
    Scenario: Check if admin able to logout without token
      Given Admin creates request for logout without token for UserLogin test case "TC23"
      When Admin calls Get Https method with valid endpoint
      Then Admin receives 401 unauthorized

    Scenario: Check if admin able to create request for the logout token after logout
      Given Admin creates request for logout after token expiration for UserLogin test case "TC24"
      When Admin calls Get Https method with valid endpoint
      Then Admin receives 401 unauthorized

  Rule: With Auth

    Background: Admin sets authorization to bearer Token with token
      Given Admin sets authorization to bearer Token with token

    Scenario: Check if admin able to generate token with valid credential
      Given Admin creates request with valid credentials for UserLogin test case "TC01"
      When Admin calls Post Https method with valid endpoint
      Then Admin receives 200 created with auto generated token

#     # Scenario: Check if admin able to logout
#     #   Given Admin creates request for logout for UserLogin test case "TC19"
#     #   When Admin calls Get Https method with valid endpoint
#     #   Then Admin receives 200 ok and response with "Logout successful"

    Scenario: Check if admin able to logout with invalid baseURL
      Given Admin creates request for logout for UserLogin test case "TC20"
      When Admin calls Get Https method with invalid baseURL
      Then Admin receives 404 Not found for invalid baseUrl

    Scenario: Check if admin able to logout with invalid endpoint
      Given Admin creates request for logout for UserLogin test case "TC21"
      When Admin calls Get Https method with invalid endpoint
      Then Admin receives 404 Not found

    Scenario: Check if admin able to logout with invalid method
      Given Admin creates request for logout for UserLogin test case "TC22"
      When Admin calls POST Https method with invalid endpoint
      Then Admin receives 405 method not allowed

# # RESET PASSWORD

#     # Scenario: Check if admin able to resetPassword
#     #   Given Admin creaes request with valid email and new password for UserLogin test case "TC25"
#     #   When Admin calls Post Https method with valid endpoint
#     #   Then Admin receives 200 ok and response with "Password saved" and true

    Scenario: Check if admin able to login with old password
      Given Admin creaes request with valid email and old password for UserLogin test case "TC26"
      When Admin calls Post Https method with valid endpoint
      Then Admin receives 401 unauthorized

    Scenario: Check if admin able to resetPassword with special characters in password
      Given Admin creaes request new password with special characters for UserLogin test case "TC27"
      When Admin calls Post Https method with valid endpoint
      Then Admin receives 400 Bad request

    Scenario: Check if admin able to resetPassword with invalid baseURL
      Given Admin creaes request with valid email and new password for UserLogin test case "TC28"
      When Admin calls Post Https method with invalid baseURL
      Then Admin receives 404 Not found for invalid baseUrl

    Scenario: Check if admin able to resetPassword with invalid endpoint
      Given Admin creaes request with valid email and new password for UserLogin test case "TC29"
      When Admin calls Post Https method with invalid endpoint
      Then Admin receives 404 not found

    Scenario: Check if admin able to resetPassword with invalid content type
      Given Admin creaes request with valid data and invalid content type for UserLogin test case "TC30"
      When Admin calls Post Https method with valid endpoint
      Then Admin receives 415 unsupported media type

    Scenario: Check if admin able to resetPassword with invalid method
      Given Admin creaes request with valid email and new password for UserLogin test case "TC31"
      When Admin calls GET Https method with valid endpoint
      Then Admin receives 405 Method not Allowed

    Scenario: Check if admin able to resetPassword with invalid email
      Given Admin creaes request new password with invalid email for UserLogin test case "TC32"
      When Admin calls Post Https method with valid endpoint
      Then Admin receives 400 Bad request response with "Invalid"
