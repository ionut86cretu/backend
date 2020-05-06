
Feature: Automating Testing Memebook Front End
  @ignore
  Scenario: Scenario 1 - verify landing screen
    Given access the application landing url
    Then i verify that page is open

  Scenario: Scenario 2 - add topic
    Given access the application landing url
    And i verify that page is open
    Then i click to add topic button
    And i add Topic Title "Auto Test"
    And i add Topic URL "https://img-9gag-fun.9cache.com/photo/az1B0yK_460swp.webp"
    And i add Topic Author "Miguel"
    When i press Submit Button
    And refresh page
    And delete all topics from database
    And the response status code should be '200'


  Scenario: Scenario 3 - verify add topic
    Given access the application landing url
    And i verify that page is open
    Then i click to add topic button
    And i add Topic Title "Auto Test"
    And i add Topic URL "https://img-9gag-fun.9cache.com/photo/az1B0yK_460swp.webp"
    And i add Topic Author "Miguel"
    And i press Submit Button
    And refresh page
    And i verify that the created topic matches
    And delete all topics from database
    And the response status code should be '200'
    #to do


  @MemebookFrontend
  Scenario: Scenario 4- add topic comment
    Given access the application landing url
    And i verify that page is open
    Then i click to add topic button
    And i add Topic Title "Auto Test"
    And i add Topic URL "https://img-9gag-fun.9cache.com/photo/az1B0yK_460swp.webp"
    And i add Topic Author "Miguel"
    And i press Submit Button
    And refresh page
    Then i open a topic
    And i add comment author "Miguel"
    And i add comment content "Yo soi embarassada con Juan Miguel"
    And i press Submit Comment Button
    And delete all topics from database
    And refresh page
    And the response status code should be '200'


    #to do
