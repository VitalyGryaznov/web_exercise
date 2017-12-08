package steps;

import cucumber.api.java.en.Then;
import hooks.SetupDriverHook;
import pageObjects.HomePage;

public class HomePageSteps {

    private SetupDriverHook setupDriverHook;


    public HomePageSteps(SetupDriverHook setupDriverHook) {

        this.setupDriverHook = setupDriverHook;
    }


    @Then("^I am on Home Page$")
    public void iAmOnHomePage() throws Throwable {

        new HomePage(setupDriverHook);
    }
}
