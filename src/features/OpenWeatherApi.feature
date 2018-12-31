
@tag
Feature: Open Weather Api 
  

  @byCityName
  Scenario: Call current weather data by City name
    Given I'm using the OpenWeatherMap Api 
    When I make a valid Api request by City name
    Then I get a valid response with Code200

  @byCityId
  Scenario: Call current weather data by City Id
    Given I am using the OpenWeatherMap Api
    When I make a valid request by City Id
    Then I get a valid response with Code200
    
  @byGeographicCoordinates
  Scenario: Call current weather data by Geographic Coordinates
    Given I am using the OpenWeatherMap Api
    When I make a valid request by Geographic Coordinates
    Then I get a valid response with Code200 

	
  @invalidApiKey
  Scenario: Call current weather data with Invalid Api Id Key
    Given I am using the OpenWeatherMap Api
    When I make an invalid request with a wrong or missing Api Id Key
    Then I get an invalid response with Code401
    
    
   