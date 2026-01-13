Feature: Batch Module

  Background:
  Given Admin sets Authorization to Bearer Token.


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
    Then Admin receives 404 Not Found Status with message and boolean success details for "<TestCase ID>"
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
    Then Admin receives 404 Not Found Status with message and boolean success details for "<TestCase ID>"
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

  @test123
  Scenario: Check if admin able to update a Batch with valid batchID and mandatory fields in request body
    Given Admin creates PUT Request with valid BatchId and Data
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 200 OK Status with updated value in response body.

