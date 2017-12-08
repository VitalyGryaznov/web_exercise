package pageObjects.wikipediaPages;

import hooks.SetupDriverHook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class WikipediaArticlePage extends BasePage {

    @FindBy(id = "firstHeading")
    private WebElement pageTitle;

    @FindBy(id = "bodyContent")
    private WebElement contentFragment;



    public WikipediaArticlePage(SetupDriverHook setupDriverHook) {
        super(setupDriverHook);
    }

    @Override
    public WikipediaArticlePage assertPageLoaded() {
        this.scenario.write("Making that wikipedia article page loaded");
        waitForVisibilityOf(pageTitle);
        waitForVisibilityOf(contentFragment);
        return this;
    }
}
