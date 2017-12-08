package steps.wikipediaSteps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hooks.SetupDriverHook;
import org.junit.Assert;
import pageObjects.wikipediaPages.WikipediaHomePage;
import pageObjects.wikipediaPages.WikipediaSearchResultsPage;

public class WikipediaSearchSteps {

    private SetupDriverHook setupDriverHook;

    private WikipediaSearchResultsPage wikipediaSearchResultsPage;

    private WikipediaHomePage wikipediaHomePage;


    public WikipediaSearchSteps(SetupDriverHook setupDriverHook) {

        this.setupDriverHook = setupDriverHook;
    }





    @When("^I Search for \"([^\"]*)\" on the HomePage$")
    public void iSearchForOnTheHomePage(String searchText) throws Throwable {

        wikipediaHomePage = new WikipediaHomePage(setupDriverHook);
        wikipediaHomePage.assertPageLoaded();
        wikipediaHomePage.makeSearch(searchText);

    }

    @Then("^I see search results page with 'did you mean' suggestion$")
    public void iSeeSearchResultsPageWithDidYouMeanSuggestion() throws Throwable {

        wikipediaSearchResultsPage = new WikipediaSearchResultsPage(setupDriverHook);
        wikipediaSearchResultsPage.assertPageLoaded();
        Assert.assertTrue("Suggestion didn't appear", wikipediaSearchResultsPage.isSuggestionPresented());

    }

    @When("^I click on the search suggestion$")
    public void iClickOnTheSearchSuggestion() throws Throwable {
        wikipediaSearchResultsPage = new WikipediaSearchResultsPage(setupDriverHook);
        wikipediaSearchResultsPage.assertPageLoaded();
        wikipediaSearchResultsPage.clickOnSuggestion();
    }

    @Then("^I see that (\\d+) search results appear$")
    public void iSeeThatSearchResultsAppear(int numberOfSearchResults) throws Throwable {

        wikipediaSearchResultsPage = new WikipediaSearchResultsPage(setupDriverHook);
        wikipediaSearchResultsPage.assertPageLoaded();
        Assert.assertTrue("Unexpected number of search results",
                wikipediaSearchResultsPage.getNumberOfSearchResults() == numberOfSearchResults);
    }

    @When("^I click on the first search result$")
    public void iClickOnTheFirstSearchResult() throws Throwable {

        wikipediaSearchResultsPage = new WikipediaSearchResultsPage(setupDriverHook);
        wikipediaSearchResultsPage.assertPageLoaded();
        wikipediaSearchResultsPage.clickOnTheFirstSearchResult();
    }
}
