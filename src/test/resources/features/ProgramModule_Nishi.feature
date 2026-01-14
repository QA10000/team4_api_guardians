Feature: Program Module

Background: Admin sets Authorization 
  
  Scenario: Check if Admin able to create a program with valid endpoint and request body with Authorization for program module
   Given Admin creates POST Request for the LMS with request body for program module
   When Admin sends HTTPS Request and request Body with endpoint for program module 
   Then Admin receives 201 Created Status with response body for program module 
 
   Scenario: Check if Admin able to create a program with valid endpoint and request body without Authorization for program module
   Given Admin creates POST Request for the LMS with request body for program module without authorization
   When Admin sends HTTPS Request and  request Body with endpoint for program module 
   Then Admin receives 401 Unauthorized for program module for program module 
  
  Scenario: Check if admin able to create a program with program description length between 4 and 25 characters
   Given Admin creates POST Request for the LMS with request body
   When Admin sends HTTPS Request and  request Body with endpoint for program module with valid description
   Then Admin receives 201 Created Status with response body for program module for valid description
  