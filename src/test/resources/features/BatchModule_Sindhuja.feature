Feature: Batch Module

## -- GET Request -- ##

  Scenario Outline:  Check if admin able to retrieve a batch with valid "<TestCase ID>"
    Given Admin creates GET Request with "<TestCase ID>"
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 200 OK Status with response body.
  Examples:
    |TestCase ID|
    | Get Valid Batch ID Generic   |
    | Get Valid Batch Name Generic |
    | Get Valid Program ID Generic |

  Scenario Outline: Check if admin able to retrieve a batch with invalid "<TestCase ID>"
    Given Admin creates GET Request with "<TestCase ID>"
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 404 "Not Found" Status with message and boolean success details for "<TestCase ID>"
    Examples:
    |TestCase ID|
    | Get Invalid Batch ID   |
    | Get Invalid Batch Name |
    | Get Invalid Program ID |


  Scenario Outline: Check if admin able to retrieve a batch after deleting the batch "<TestCase ID>"
    Given Admin creates GET Request with "<TestCase ID>"
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 200 OK Status with  "batchStatus" field "Inactive" in the response body.
  Examples:
    |TestCase ID|
    | Get Valid Batch ID after delete   |
    | Get Valid Batch Name after delete |


  Scenario Outline: Check if admin able to retrieve a batch with invalid endpoint "<TestCase ID>"
    Given Admin creates GET Request with "<TestCase ID>"
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 404 not found  Status
    Examples:
      |TestCase ID|
      | Get Valid Batch ID with invalid endpoint   |
      | Get Valid Batch Name with invalid endpoint |
      | Get Program ID with invalid endpoint       |

## -- DELETE REQUEST -- ##
  Scenario Outline: Check if admin able to delete a Batch with "<TestCase ID>"
    Given Admin creates DELETE Request with "<TestCase ID>"
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 200 OK Status with response body.
    Examples:
      |TestCase ID|
      | Delete Valid Batch ID Generic |

  Scenario Outline: Check if admin able to delete a invalid Batch with "<TestCase ID>"
    Given Admin creates DELETE Request with "<TestCase ID>"
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 404 "Not Found" Status with message and boolean success details for "<TestCase ID>"
    Examples:
      |TestCase ID|
      | Delete Invalid Batch ID |

  Scenario Outline: Check if admin able to delete a batch with invalid endpoint "<TestCase ID>"
    Given Admin creates DELETE Request with "<TestCase ID>"
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 404 not found  Status
    Examples:
      |TestCase ID|
      | Delete batch with invalid endpoint |

## -- PUT REQUEST -- ##

  Scenario Outline: Check if admin able to update a Batch with valid batchID and mandatory fields in request body and update a Batch with a deleted batchID
    Given Admin creates PUT Request with "<TestCase ID>"
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 200 OK Status with updated value in response body for "<TestCase ID>"
    Examples:
      |TestCase ID|
      | Put Valid Batch ID Generic |
      | Put Batch with deleted batchId |

  Scenario Outline: Check if admin able to update a Batch with invalid batchID and mandatory fields in request body
    Given Admin creates PUT Request with "<TestCase ID>"
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 404 "Not Found" Status with message and boolean success details for "<TestCase ID>"
    Examples:
      |TestCase ID|
      | Put Invalid Batch ID |

  Scenario Outline: Check if admin able to update a Batch with valid batchID and missing mandatory fields request body
    Given Admin creates PUT Request with "<TestCase ID>"
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 400 "Bad Request" Status with message and boolean success details for "<TestCase ID>"
    Examples:
      |TestCase ID|
      | Put Batch ID with missing batchName |
      | Put Batch ID with missing batchStatus |

  Scenario Outline: Check if admin able to update a batch with invalid data
    Given Admin creates PUT Request with "<TestCase ID>"
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 400 "Bad Request" Status with message and boolean success details for "<TestCase ID>"
    Examples:
      |TestCase ID|
      | Put Batch with invalid data |
  @test123
  Scenario Outline: Check if admin able to update a Batch with invalid endpoint
    Given Admin creates PUT Request with "<TestCase ID>"
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 404 not found  Status
    Examples:
      |TestCase ID|
      | Put Batch with invalid endpoint |

#  Scenario: Check if admin able to update a Batch with a valid batchID and deleted programID field  in the request body with other mandatory fields
#    Given Admin creates PUT Request with Valid batch Id
#    When Admin sends HTTPS Request with endpoint
#    Then Admin receives 400 Bad Request Status with message and boolean success details





