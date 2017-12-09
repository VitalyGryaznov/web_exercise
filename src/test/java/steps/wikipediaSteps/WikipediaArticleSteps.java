package steps.wikipediaSteps;

import cucumber.api.java.en.Then;
import hooks.SetupDriverHook;
import pageObjects.wikipediaPages.WikipediaArticlePage;

public class WikipediaArticleSteps {

    private SetupDriverHook setupDriverHook;
    private WikipediaArticlePage wikipediaArticlePage;

    public WikipediaArticleSteps(SetupDriverHook setupDriverHook) {
        this.setupDriverHook = setupDriverHook;
    }

    @Then("^I see article page with a title and a table of contents$")
    public void iSeeArticlePageWithATitleAndATableOfContents() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        wikipediaArticlePage = new WikipediaArticlePage(setupDriverHook);
        wikipediaArticlePage.assertPageLoaded();
    }
}
