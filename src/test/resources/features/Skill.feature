Feature: Skill Module for LMS API

  Background: Admin sets Authorization to Bearer Token.

#--------------- POST OPERATION ----------------

Scenario: Check if admin able to create a New Skill Master with valid endpoint and request body (non existing values)
   Given Admin creates POST Request for New Skill Master for the LMS API endpoint "TC01"
   When Admin sends HTTPS Request and request Body with mandatory fields for New Skill Master                                                                                   
   Then Admin receives 201 Created Status with response body  

Scenario: Check if admin able to create a New Skill Master with valid endpoint and request body (existing values)
   Given Admin creates POST Request for New Skill Master for the LMS API endpoint "TC02"
   When Admin sends HTTPS Request and request Body with mandatory fields for New Skill Master                                                                                   
   Then Admin receives 400 Bad Request Status with message "cannot create skillMaster,since already exists"

Scenario: Check if admin able to create a New Skill Master with valid endpoint and request body (missing some mandatory fields)
   Given Admin creates POST Request for New Skill Master for the LMS API endpoint "TC03"
   When Admin sends HTTPS Request and request Body with mandatory fields for New Skill Master                                                                                       
   Then Admin receives 500 Error
   
#--------------- GET ALL OPERATION -------------------
 
Scenario: Check if admin able to get all  Skill Master with valid endpoint 
   Given Admin creates GET Request for the LMS API endpoint "TC04"
   When Admin sends HTTPS Request for get all Skill Master details                                                                                    
   Then Admin receives 200 Status with response body(showing all the list of skills)
   
#--------------- GET OPERATION -------------------

Scenario: Check if admin able to get Skill Master Name with valid endpoint  
   Given Admin creates GET Request to get Skill Master by Name for the LMS API endpoint "TC05"
   When Admin sends HTTPS Request with SkillMasterName                                                                                      
   Then Admin receives 200 Status with response body 
   
Scenario: Check if admin able to get Skill Master Name with invalid endpoint  
   Given Admin creates GET Request to get Skill Master Name with invalid endpoint for the LMS API "TC06"
   When Admin sends HTTPS Request with invalid SkillMasterName                                                                                  
   Then Admin receives 404 Not Found Status with message "skill with idSQLsnot found"

#--------------- PUT OPERATION -------------------

Scenario: Check if admin able to update New Skill Master with valid endpoint and request body 
   Given Admin creates  PUT Request to update New Skill Master for the LMS API endpoint "TC07"
   When Admin sends HTTPS Request and request Body to update New Skill Master with mandatory fields                                                                                    
   Then Admin receives 200 Status with updated response body
   
 Scenario: Check if admin able to update New Skill Master with invalid endpoint and request body
   Given Admin creates  PUT Request to update New Skill Master with invalid endpoint for the LMS API endpoint "TC08"
   When Admin sends HTTPS Request and request Body with mandatory with wrong skillID                                                                                       
   Then Admin receives 400 Bad Request with   "error:Bad Request"
 
#--------------- DELETE OPERATION -------------------

 Scenario: Check if admin able to Delete  Skill ID  with valid endpoint 
   Given Admin creates  DELETE Request to Delete  Skill ID for the LMS API endpoint "TC09"
   When Admin sends HTTPS Request to Delete  Skill ID                                                                                     
   Then Admin receives 200 Status 
 
 Scenario: Check if admin able to Delete  Skill ID  with invalid endpoint 
   Given Admin creates  DELETE Request for the LMS API endpoint "TC10"
   When Admin sends HTTPS Request to Delete  Skill ID  with invalid endpoint                                                                                        
   Then Admin receives 404 Error with response body "no record found with skillId"
 