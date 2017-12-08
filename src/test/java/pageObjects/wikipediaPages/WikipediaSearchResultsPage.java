package pageObjects.wikipediaPages;

import hooks.SetupDriverHook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

import java.util.List;

public class WikipediaSearchResultsPage extends BasePage {

    private static final String DIRECT_LINK = "https://www.wikipedia.org/";

    @FindBy(id = "firstHeading")
    private WebElement pageTitle;

    @FindBy(css = ".searchresults")
    private WebElement searchResultsFragment;

    @FindBy(css = ".searchdidyoumean")
    private WebElement searchDidYouMeanFragment;

    @FindBy(id = "mw-search-DYM-suggestion")
    private WebElement searchSuggestionLink;

    //created this element to avoid using searchResultLinks[0], that can cause longer execution time
    @FindBy(css = ".mw-search-result-heading > a")
    private WebElement firstSearchResultLink;

    @FindBy(css = ".mw-search-result-heading > a")
    protected List<WebElement> searchResultLinks;

    public WikipediaSearchResultsPage(SetupDriverHook setupDriverHook) {
        super(setupDriverHook);
    }

    @Override
    public WikipediaSearchResultsPage assertPageLoaded() {
        this.scenario.write("Making assertion that I'm on Wikipedia Search results page");
        waitForVisibilityOf(pageTitle);
        waitForVisibilityOf(searchResultsFragment);
        return this;
    }

    public boolean isSuggestionPresented() {
        this.scenario.write("Checking if suggestion appeared");
        return searchDidYouMeanFragment.isDisplayed();
    }

    public WikipediaSearchResultsPage clickOnSuggestion() {
        this.scenario.write("Clicking on search suggestion link");
        waitForClickabilityAndClickOn(searchSuggestionLink);
        return this;
    }

    public int getNumberOfSearchResults() {
        this.scenario.write("Waiting for the first search result to be visible");
        waitForVisibilityOf(firstSearchResultLink);
        this.scenario.write("Getting total number of search results");
        return  searchResultLinks.size();
    }

    public WikipediaArticlePage clickOnTheFirstSearchResult() {
        this.scenario.write("Click ing on the first search result");
        waitForClickabilityAndClickOn(firstSearchResultLink);
        return new WikipediaArticlePage(setupDriverHook);
    }
}
