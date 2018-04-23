
@tag
Feature: Testing out the Google Places API
  I want to use this template for my feature file

  @tag1
  Scenario: Checking out places search in google
    Given I set "query" parameter as "restaurants+in+Sydney"
    And add "key" parameter as "AIzaSyBLzFAnW-1XE28hZ2BpJxcpGOquAdBZ8sQ"
    When I want to open "https://maps.googleapis.com" endpoint
    And use the "/maps/api/place/textsearch/json" resource
    And trigger the get request
    Then the number of restaurants should be 21
    
    #Given test it out
    #And I try to get "json?query=restaurants+in+Sydney&key=AIzaSyBLzFAnW-1XE28hZ2BpJxcpGOquAdBZ8sQ"
    #Then I print out the response
 
  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
