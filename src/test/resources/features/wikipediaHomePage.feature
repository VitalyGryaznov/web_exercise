Feature: Wikipedia Home Page
  Home page should contain all expected elements

  Scenario: Assert the site's title is wikipedia

    When I go to Wikipedia home page
    Then I see that site's title is "Wikipedia"