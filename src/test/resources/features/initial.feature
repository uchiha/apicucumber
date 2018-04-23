
@tag
Feature: Testing out the Google Places API
  I want to use this template for my feature file

  @numRestaurants
  Scenario: Check out the number of restaurants in Sydney
    Given I set "query" parameter as "restaurants+in+Sydney"
    And add "key" parameter as "AIzaSyBLzFAnW-1XE28hZ2BpJxcpGOquAdBZ8sQ"
    When I want to open "https://maps.googleapis.com" endpoint
    And use the "/maps/api/place/textsearch/json" resource
    And trigger the get request
    Then the number of restaurants should be 20
    
  @specificRestaurant
  Scenario: Check out the number of restaurants in Sydney
    Given I set "query" parameter as "restaurants+in+Sydney"
    And add "key" parameter as "AIzaSyBLzFAnW-1XE28hZ2BpJxcpGOquAdBZ8sQ"
    When I want to open "https://maps.googleapis.com" endpoint
    And use the "/maps/api/place/textsearch/json" resource
    And trigger the get request
    Then the first restaurant should be "Tetsuya's Restaurant"
    
  
