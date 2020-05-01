@BackendApiComment
Feature: Automating Testing Comment API

  Scenario: Scenario 1 - Add Comment to Topics via Post Comment API
    Given the new topic is created via Topic API
    And the response status code should be '200'
    When the new comment is added via Comment API
    And the response status code should be '200'
    Then delete the topic from database
    And the response status code should be '200'

  Scenario: Scenario 2 - Delete Comment to Topics via Delete Comment API
    Given the new topic is created via Topic API
    And the response status code should be '200'
    When the new comment is added via Comment API
    And the response status code should be '200'
    Then delete the comment from database
    And the response status code should be '200'
    And delete the topic from database
    And the response status code should be '200'
