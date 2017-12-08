package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hooks.SetupDriverHook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.TouchAction;
import pageObjects.wikipediaPages.WikipediaHomePage;

public class CommonSteps {

    private SetupDriverHook setupDriverHook;


    public CommonSteps(SetupDriverHook setupDriverHook) {

        this.setupDriverHook = setupDriverHook;
    }





    @When("^Resize the window width to (\\d+) px$")
    public void resizeTheWindowWidthToPx(int width) throws Throwable {
        int currentHeight  =setupDriverHook.getDriver().manage().window().getSize().getHeight();
        Dimension dimension = new Dimension(width, currentHeight);
        setupDriverHook.getDriver().manage().window().setSize(dimension);
    }

}
