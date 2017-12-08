package steps;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hooks.SetupDriverHook;
import models.UserModel;
import pageObjects.LoginPage;
import utils.DataHelper;

public class LoginSteps {


    private SetupDriverHook setupDriverHook;
    private UserModel userData;

    public LoginSteps(SetupDriverHook setupDriverHook) {
        this.setupDriverHook = setupDriverHook;
    }


    @Before
    public void before(Scenario scenario) {

        setupDriverHook.setScenario(scenario);
    }


    @Then("^I am on Login Page$")
    public void iAmOnLoginPage() throws Throwable {

        new LoginPage(setupDriverHook);
    }


    @When("^I submit login form with valid credentials as \"([^\"]*)\"$")
    public void iEnterValidEmailAndPasswordAs(String profileName) throws Throwable {

        userData = DataHelper.getUserData(profileName);

        new LoginPage(setupDriverHook)
                .enterMail(userData.getEMAIL())
                .enterPassword(userData.getPASSWORD())
                .submitLoginForm();
    }
}
