package steps.travelexSteps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import hooks.SetupDriverHook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageObjects.travelexPages.TravelexHomePage;
import pageObjects.wikipediaPages.WikipediaArticlePage;

public class TravelexHomePageSteps {

    private SetupDriverHook setupDriverHook;

    private TravelexHomePage travelexHomePage;




    public TravelexHomePageSteps(SetupDriverHook setupDriverHook) {

        this.setupDriverHook = setupDriverHook;
    }




    @And("^Swipe left on the slider (\\d+) times$")
    public void swipeLeftOnTheSliderTimes(int numberOfSwipes) throws Throwable {
        travelexHomePage = new TravelexHomePage(setupDriverHook);
        for (int i=0; i< numberOfSwipes; i++) {
            travelexHomePage.swipeLeftCardsSlider(numberOfSwipes);
        }

    }

    @Given("^I go to Travelex home page$")
    public void iGoToTravelexHomePage() throws Throwable {
        travelexHomePage = new TravelexHomePage(setupDriverHook);
        travelexHomePage.openItWithDirectLink();
    }

    @Then("^I see that card displayed is indeed the (\\d+) item$")
    public void iSeeThatCardDisplayedIsIndeedTheItem(int number) throws Throwable {
        travelexHomePage = new TravelexHomePage(setupDriverHook);
        Assert.assertTrue("Current displayed card number isn't" + number,
                travelexHomePage.currentDisplayedCardNumberIs(number));
    }
}
