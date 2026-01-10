Feature: Batch Module

  Background: Admin sets Authorization to Bearer Token.

  Scenario: Check if admin able to retrieve a batch with valid BATCH ID
    Given Admin creates GET Request with valid Batch ID
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 200 OK Status with response body.