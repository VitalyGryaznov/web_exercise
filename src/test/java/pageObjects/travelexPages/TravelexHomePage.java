package pageObjects.travelexPages;

import hooks.SetupDriverHook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class TravelexHomePage extends BasePage {

    private static final String DIRECT_LINK = "https://www.travelex.co.uk/";

    @FindBy(css = ".simple__animation")
    private WebElement homeCards;

    @FindBy(css = ".hiw__header")
    private WebElement howItWorksHeader;

    private WebElement getCurentlyVisibleCartDotNumber(int number) {
        return setupDriverHook.getDriver().findElement(By.xpath(String.format("//ul[@class='slick-dots']/li[%d]", number)));
    }

    public TravelexHomePage(SetupDriverHook setupDriverHook) {
        super(setupDriverHook);
    }

    @Override
    public TravelexHomePage assertPageLoaded() {
        this.scenario.write("Making that wikipedia article page loaded");
        waitForVisibilityOf(homeCards);
        waitForVisibilityOf(howItWorksHeader);
        return this;
    }

    public void swipeLeftCardsSlider(int numberOfSwipes) {
        WebDriver driver = setupDriverHook.getDriver();
        Dimension size = driver.manage().window().getSize();
        Actions builder = new Actions(driver);
        builder.clickAndHold(homeCards).moveByOffset(-homeCards.getSize().getWidth() / 2, 0).release().perform();
    }

    public TravelexHomePage openItWithDirectLink() {
        this.scenario.write("Opening Travelex Home Page with direct link" + DIRECT_LINK);
        setupDriverHook.getDriver().get(DIRECT_LINK);
        return this.assertPageLoaded();
    }

    public boolean currentDisplayedCardNumberIs(int number) {
        return getCurentlyVisibleCartDotNumber(number).getAttribute("class").equals("slick-active");
    }
}
