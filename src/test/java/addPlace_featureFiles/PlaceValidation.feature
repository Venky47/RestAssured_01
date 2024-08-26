@GoogleTestAPI
Feature: Validate the place API's

  @AddPlace
  Scenario: Verify if place is added successfully using AddPlaceAPI
    Given Add place payload
    When user calls "AddPlaceAPI" with POST http request
    Then the API call got success with status code "200"
    And "status" in response body is "OK"
    And "scope" in response body is "APP"

 @Add&GetPlace
  Scenario Outline: Verify if place is added successfully using AddPlaceAPI
    Given Add place payload with "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" with "POST" http request
    Then the API call got success with status code "200"
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    Then get the "place_id"
    When user calls "GetPlaceAPI" with "GET" http request
    Then verify the "<name>" is present in the body
    Examples:
      | name    | language | address   |
      | Rainbow | English  | Bengaluru |
      |1st home |Kannada   |Mysore     |

   @DeletePlace
  Scenario: verify the delete API
    Given delete API payload
    When user calls "DelPlaceAPI" with "POST" http request
    Then the API call got success with status code "200"
    And "status" in response body is "OK"