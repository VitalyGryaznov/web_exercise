package steps;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import hooks.SetupDriverHook;
import org.openqa.selenium.Dimension;

public class CommonSteps {

    private SetupDriverHook setupDriverHook;

    public CommonSteps(SetupDriverHook setupDriverHook) {
        this.setupDriverHook = setupDriverHook;
    }

    @Before
    public void before(Scenario scenario) {
        setupDriverHook.setScenario(scenario);
    }

    @When("^Resize the window width to (\\d+) px$")
    public void resizeTheWindowWidthToPx(int width) throws Throwable {
        int currentHeight = setupDriverHook.getDriver().manage().window().getSize().getHeight();
        Dimension dimension = new Dimension(width, currentHeight);
        setupDriverHook.getDriver().manage().window().setSize(dimension);
    }
}
