Feature: API Demo Feature

  Scenario: Looking up US locations by post code(fail test)
    When I look up a post code for country code
    Then the resulting location should be in a Country
    And the results should have a correct State abbr

Scenario: Get available Anime
    Given I Set POST service api endpoint
      When Send a POST HTTP request
      Then I receive valid Response

  Scenario: Finding My Cat
    Given Kitty is available in the pet store
    When I ask for a pet using Kitty's ID
    Then I get Kitty as result

  Scenario: Finding Available animals
    Given Get available pet in the store
    When Check the response code ok
    When I ask for a pet using Kitty's ID
    Then I get Kitty as result

    Scenario: Pet not found (Negative Test)
      Given I do a GET pet from the pet store
      When Get response status
      Then I verify if the pet is not availabe

