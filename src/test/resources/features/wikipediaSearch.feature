Feature: Wikipedia Search
  User should be able to use search on all pages.
  User should be able to find relevant articles.
  User should be able to use suggestions

  Scenario: I am able to perform search and use suggestions on the home page

    When I go to Wikipedia home page
    And I Search for "furry rabbits" on the HomePage
    Then I see search results page with 'did you mean' suggestion
    When I click on the search suggestion
    Then I see that 20 search results appear
    When I click on the first search result
    Then I see article page with a title and a table of contents