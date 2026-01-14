Feature: User Module

  Background: Admin sets Authorization to Bearer Token.

#--------------- POST OPERATION ----------------
  Scenario: Check if admin able to create a new User with valid endpoint and request body 
    Given Admin creates POST Request for new user with the LMS API endpoint test case "TC01"
    When Admin sends HTTPS Request and request Body with mandatory,additional fields                                                                                  
    Then Admin receives 200 OK Status with response body

  #Scenario: Check if admin able to create a admin with valid endpoint and request body (existing values in phone no) 
    #Given Admin creates POST Request for the LMS API endpoint "TC02"
    #When Admin sends HTTPS Request and request Body with mandatory,additional fields                                                                                                                  
    #Then Admin receives 400 Bad Request Status with message and boolean success details
  #
  #Scenario: Check if admin able to create a admin missing mandatory fields in request body 
    #Given Admin creates POST Request for the LMS API endpoint "TC03"
    #When Admin sends HTTPS Request and request Body  (missing mandatory fields)                                                                                                               
    #Then Admin receives 400 Bad Request Status with message and boolean success details
#
#--------------- GET ALL OPERATION -------------------
    #
  #Scenario: Check if admin able to retrieve all admin with valid LMS API 
    #Given Admin creates GET Request for the LMS API All admin endpoint "TC04"
    #When Admin sends HTTPS Request                                                                                                             
    #Then Admin receives 200 OK Status with response body                       
     #
#--------------- GET By ID OPERATION -------------------
#
  #Scenario: Check if admin able to retrieve a admin with valid admin ID 
    #Given Admin creates GET Request for the LMS API endpoint with valid admin ID "TC05"
    #When Admin sends HTTPS Request                                                                                                             
    #Then Admin receives 200 OK Status with response body                                                                                      
   #
#	Scenario: Check if admin able to retrieve a admin with invalid admin ID 
    #Given Admin creates GET Request for the LMS API endpoint with invalid admin ID "TC06"
    #When Admin sends HTTPS Request                                                                                   
    #Then Admin receives 404 Not Found Status with message and boolean success details
 #
 #--------------- GET All Staff OPERATION -------------------
 #
 #	Scenario: Check if admin able to retrieve a admin with valid LMS API 
    #Given Admin creates GET Request for the LMS API All Staff endpoint "TC07"
    #When Admin sends HTTPS Request                                                                                   
    #Then Admin receives 200 OK Status with response body                                                                
 #
 #--------------- GET By Admin and Role OPERATION --------------
 #
 #	Scenario: Check if admin able to retrieve a admin with valid LMS API 
    #Given Admin creates GET Request for the LMS API admin Roles endpoint "TC08"
    #When Admin sends HTTPS Request                                                                                    
    #Then Admin receives 200 OK Status with response body                                                                 
#
 #--------------- PUT OPERATION (update User by userID)------------------------                                                               
 #
 #Scenario: Check if admin able to update a admin with valid admin Id and request body 
    #Given Admin creates PUT Request for the LMS API endpoint "TC09"
    #When Admin sends HTTPS Request and request Body with mandatory and additional fields                                                                                                                      
    #Then Admin receives 200 OK  Status with response body   
 #
 #Scenario: Check if admin able to update a admin with invalid admin Id and request body 
    #Given Admin creates PUT Request for the LMS API endpoint "TC10"
    #When Admin sends HTTPS Request and request Body with mandatory and additional fields                                                                                                                       
    #Then Admin receives 404 Not Found Status with message and boolean success details   
 #
 #Scenario: Check if admin able to update a admin with valid admin ID and missing mandatory fields request body 
    #Given Admin creates PUT Request for the LMS API endpoint  and Valid batch Id "TC11"
    #When Admin sends HTTPS Request  and request Body  (missing mandatory fields)                                                                                                                       
    #Then Admin receives 400 Bad Request Status with message and boolean success details   
                                                           #
#
  #--------------- PUT OPERATION (update User Role by userID) ------------------------                    
                                                                #
  #Scenario: Check if admin able to update a admin with valid admin Id and request body 
    #Given Admin creates PUT Request for the LMS API endpoint "TC12"
    #When Admin sends HTTPS Request and  request Body with mandatory fields      #(Mandatory : Role ID and Role status)                                                                                                                   
    #Then Admin receives 200 Ok Status with response message   # Eg : adminStatus Updated for admin: {adminID}
    #
  #Scenario: Check if admin able to update a admin with invalid admin Id and request body 
    #Given Admin creates PUT Request for the LMS API endpoint "TC13"
    #When Admin sends HTTPS Request and  request Body with mandatory fields      #(Mandatory : Role ID and Role status)                                                                                                                                                                             
    #Then Admin receives 404 Not Found Status with message and boolean success details
 #
 #Scenario: Check if admin able to update a admin with valid admin Id and request body (missing field) 
    #Given Admin creates PUT Request for the LMS API endpoint "TC14"
    #When Admin sends HTTPS Request and  request Body with missing mandatory fields                #(Mandatory : Role ID and Role status)                                                                                                                                                                                                                                             
    #Then Admin receives 400 Bad Request Status with message and boolean success details
 #
 #
  #--------------- PUT OPERATION (Assign user to program/btach by userID) ------------------------  
 #
 #Scenario: Check if admin able to assign admin to program / batch with valid admin Id and request body
    #Given Admin creates PUT Request for the LMS API endpoint  "TC15"
    #When Admin sends HTTPS Request and  request Body with mandatory fields    #(Mandatory : program Id, batch Id ,role id, admin id, admin role program batch status)                                                                                                                                             
    #Then Admin receives 200 Ok Status with response message  #Eg : admin {adminID}  has been successfully assigned to Program/Batch(es)  
 #
# 
 
 
 
 
 
 
 
	    




