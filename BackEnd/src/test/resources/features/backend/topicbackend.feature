@BackendApiTopic
Feature: Automating Testing Topic API

  Scenario: Scenario 1 - Create Topics API
    Given the new topic is created via Topic API
    When the response status code should be '200'
    Then delete the topic from database
    And the response status code should be '200'

  @Ignore
  Scenario: Scenario 2 - Get All Topics API
    Given the new topic is created via Topic API
    And the response status code should be '200'
    #todo

  Scenario: Scenario 3 - Get Topics By Id API
    Given the new topic is created via Topic API
    And the response status code should be '200'
    When get the Topic by id via Topics API
    Then the response status code should be '200'
    #And the response body contain created topic
    And delete the topic from database
    And the response status code should be '200'


  Scenario: Scenario 4 - Vote Up Topic API
    Given the new topic is created via Topic API
    And the response status code should be '200'
    When I voted up topic via Topic API
    And the response status code should be '200'
    Then the number of votes up equals with '1'
    And delete the topic from database
    And the response status code should be '200'

  #todo
  @Ignore
  Scenario: Scenario 5 - Vote Down Topic API

