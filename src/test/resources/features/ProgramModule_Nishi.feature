Feature: Program Module

 Scenario: Check if admin able to generate token with valid credential
      Given Admin creates request with valid credentials for UserLogin test case "TC01"
      When Admin calls Post Https method with valid endpoint
      Then Admin receives 200 created with auto generated token
  
  Scenario: Check if Admin able to create a program with valid endpoint and request body with Authorization for program module
   Given Admin creates POST Request for the LMS with request body for program module
   When Admin sends HTTPS Request and request Body with endpoint for program module 
   Then Admin receives 200 Created Status with response body for program module 
 
   Scenario: Check if Admin able to create a program with valid endpoint and request body without Authorization for program module
   Given Admin creates POST Request for the LMS with request body for program module without authorization
   When Admin sends HTTPS Request and  request Body with endpoint for program module 
   Then Admin receives 401 Unauthorized for program module for program module 
  
  Scenario: Check if admin able to create a program with program description length between 4 and 25 characters
   Given Admin creates POST Request for the LMS with request body
   When Admin sends HTTPS Request and  request Body with endpoint for program module with valid description
   Then Admin receives 201 Created Status with response body for program module for valid description
  
  Scenario: Check if Admin able to create a program with invalid endpoint
  Given Admin creates POST Request for the LMS with request body
  When Admin sends HTTPS Request and  request Body with endpoint
  Then Admin receives 404 not found  Status with message and boolean success details
 
   Scenario: Check if Admin able to create a program with already existing program name
   Given Admin creates POST Request for the LMS with request body
   When Admin sends HTTPS Request and  request Body with endpoint
   Then Admin receives 400 Bad Request Status with message and boolean success details
 
   Scenario: Check if Admin able to create a program with invalid method
   Given Admin creates POST Request for the LMS with request body
   When Admin sends HTTPS Request and  request Body with endpoint
   Then Admin receives 405 Method Not Allowed

   Scenario: Check if Admin able to create a program with invalid request body
   Given Admin creates POST Request for the LMS with invalid request body for program
   When Admin sends HTTPS Request and  request Body with endpoint for program module
   Then Admin receives 400 Bad Request Status
 
   Scenario: Check if Admin able to create a program with missing values in the request body
   Given Admin creates POST Request for the LMS with request body
   When Admin sends HTTPS Request and  request Body with endpoint
   Then Admin receives 400 Bad Request Status
 
   Scenario: Check if Admin able to create a program with missing additional field
   Given Admin creates POST Request for the LMS with request body
   When Admin sends HTTPS Request and  request Body with endpoint
   Then Admin receives 200 ok
 
   Scenario: Check if Admin able to retrieve all programs with valid Endpoint
   Given Admin creates GET Request for the LMS API for valid endpoint
   When Admin sends HTTPS Request with endpoint
   Then Admin receives 200 OK Status with response body.
 
   Scenario: Check if Admin able to retrieve all programs with invalid Endpoint
   Given Admin creates GET Request for the LMS API for invalid endpoint
   When Admin sends HTTPS Request with endpoint
   Then Admin receives 404 not found  Status with error message
 
   Scenario: Check if Admin able to retrieve all programs with invalid Method
   Given Admin creates GET Request for the LMS API for invalid method
   When Admin sends HTTPS Request with endpoint
   Then Admin receives 405 Method Not Allowed
 
   Scenario: Check if Admin able to retrieve all programs without Authorization
   Given Admin creates GET Request for the LMS API
   When Admin sends HTTPS Request with endpoint
   Then Admin receives 401 Status with response body as Unauthorized
 
   Scenario: Check if Admin able to retrieve a program with valid program ID
   Given Admin creates GET Request for the LMS API for valid id
   When Admin sends HTTPS Request with endpoint
   Then Admin receives 200 OK Status with response body.
 
   Scenario: Check if Admin able to retrieve a program with invalid program ID
   Given Admin creates GET Request for the LMS API for invalid id
   When Admin sends HTTPS Request with endpoint
   Then Admin receives 404 Not Found Status with message and boolean success details
 
   Scenario: Check if Admin able to retrieve a program with invalid baseURI
   Given Admin creates GET Request for the LMS API for invalid baseURI
   When Admin sends HTTPS Request with endpoint
   Then Admin receives 404 Not Found Status with message and boolean success details

   Scenario: Check if Admin able to retrieve a program without Authorization
   Given Admin creates GET Request for the LMS API for without Authorization
   When Admin sends HTTPS Request with endpoint
   Then Admin receives 401 Unauthorized
 
  Scenario: Check if Admin able to retrieve a program with invalid Endpoint
  Given Admin creates GET Request for the LMS API for Invalid Endpoint
  When Admin sends HTTPS Request with endpoint
  Then Admin receives 404 Not Found Status with message and boolean success details

  Scenario: Check if Admin able to update a program with valid programID endpoint  and valid request body
  Given Admin creates PUT Request for the LMS API  with missing mandatory fields
  When Admin sends HTTPS Request with valid endpoint
  Then Admin receives 400 Bad Request Status with message and boolean success details
 
  Scenario: Check if Admin able to update a program without request body
  Given Admin creates PUT Request for the LMS API  with missing mandatory fields
  When Admin sends HTTPS Request with valid endpoint
  Then Admin receives 400 Bad Request Status with message and boolean success details

  Scenario: Check if Admin able to update a program with invalid baseURI
  Given Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields.
  When Admin sends HTTPS Request with valid endpoint
  Then Admin receives 404 Not Found Status with message and boolean success details
 
  Scenario: Check if Admin able to update a program with invalid method
  Given Admin creates PUT Request for the LMS API endpoint with request Body
  When Admin sends HTTPS Request with valid endpoint
  Then Admin receives 405 Method Not Allowed

  Scenario: Check if Admin able to update a program without Authorization
  Given Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields.
  When Admin sends HTTPS Request with valid endpoint
  Then Admin receives 401 Unauthorized


  