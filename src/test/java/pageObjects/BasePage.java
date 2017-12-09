package pageObjects;

import cucumber.api.Scenario;
import hooks.SetupDriverHook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    final WebDriver driver;
    protected Scenario scenario;
    private final int globalTimeout = 15;
    protected SetupDriverHook setupDriverHook;

    public abstract BasePage assertPageLoaded();

    public BasePage(SetupDriverHook setupDriverHook) {
        this.setupDriverHook = setupDriverHook;
        this.driver = setupDriverHook.getDriver();
        PageFactory.initElements(this.driver, this);
        this.scenario = setupDriverHook.getScenario();
    }

    protected WebElement waitForVisibilityOf(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, globalTimeout);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    protected void enterTextInTextField(WebElement fieldElement, String textToEnter) {
        waitForVisibilityOf(fieldElement).clear();
        fieldElement.sendKeys(textToEnter);
    }

    protected void waitForClickabilityAndClickOn(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, globalTimeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
}

