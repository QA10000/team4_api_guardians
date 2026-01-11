Feature: Batch Module

  Background:
  Given Admin sets Authorization to Bearer Token.

  Scenario: Check if admin able to retrieve a batch with valid BATCH ID
    Given Admin creates GET Request with valid Batch ID
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 200 OK Status with response body.

  Scenario: Check if admin able to retrieve a batch with valid BATCH NAME
    Given Admin creates GET Request with valid Batch Name
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 200 OK Status with response body.
  @test123
  Scenario: Check if admin able to retrieve a batch with valid Program ID
    Given Admin creates GET Request with valid Program Id
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 200 OK Status with response body.

  Scenario: Check if admin able to delete a Batch with valid Batch ID
    Given Admin creates DELETE Request with valid BatchId
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 200 OK Status with response body.