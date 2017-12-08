package steps.wikipediaSteps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import hooks.SetupDriverHook;
import org.junit.Assert;
import pageObjects.HomePage;
import pageObjects.wikipediaPages.WikipediaHomePage;

public class WikipediaHomePageSteps {

    private SetupDriverHook setupDriverHook;


    public WikipediaHomePageSteps(SetupDriverHook setupDriverHook) {

        this.setupDriverHook = setupDriverHook;
    }


    @Given("^I go to Wikipedia home page$")
    public void iGoToWikipediaHomePage() throws Throwable {

        WikipediaHomePage wikipediaHomePage = new WikipediaHomePage(setupDriverHook);
        wikipediaHomePage.openItWithDirectLink();

    }

    @Then("^I see that site's title is \"([^\"]*)\"$")
    public void iSeeThatSiteSTitleIsWikipedia(String titleText) throws Throwable {

        Assert.assertEquals(titleText,
                new WikipediaHomePage(setupDriverHook).assertPageLoaded()
                        .getPageTitle()
        );
    }
}
