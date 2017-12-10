Feature: Wifdsfsgkipedia Search


  Background:
    Given I go to Travelex home page

  Scenario Outline: I am able to perform search and use suggestions on the home page

    When Resize the window width to <width> px
    And Swipe left on the slider <numberOfSwipesToDo> times
    Then I see that card displayed is indeed the <expectedNumberOfCurrentlyDisplayedCard> item

    Examples:
      | width | numberOfSwipesToDo | expectedNumberOfCurrentlyDisplayedCard |
      | 500   | 2                  | 3                                      |
