package pageObjects.wikipediaPages;

import hooks.SetupDriverHook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class WikipediaHomePage extends BasePage {

    private static final String DIRECT_LINK = "https://www.wikipedia.org/";

    @FindBy(css = "h1 .central-textlogo__image")
    private WebElement homePageTitle;

    @FindBy(id = "searchInput")
    private WebElement searchInput;

    @FindBy(css = "img.central-featured-logo")
    private WebElement centralLogo;

    @FindBy(css = "button[type=submit]")
    private WebElement submitButton;

    public WikipediaHomePage(SetupDriverHook setupDriverHook) {
        super(setupDriverHook);
    }

    @Override
    public WikipediaHomePage assertPageLoaded() {
        this.scenario.write("Making assertion that I'm on Wikipedia Home Page");
        waitForVisibilityOf(homePageTitle);
        waitForVisibilityOf(searchInput);
        waitForVisibilityOf(centralLogo);
        return this;
    }

    public WikipediaHomePage openItWithDirectLink() {
        this.scenario.write("Opening Wikipedia Home Page with direct link" + DIRECT_LINK);
        setupDriverHook.getDriver().get(DIRECT_LINK);
        return this.assertPageLoaded();
    }

    public String getPageTitle() {
        this.scenario.write("Getting Wikipedia Home Page title text");
        return homePageTitle.getText();
    }

    public WikipediaSearchResultsPage makeSearch(String searchText) {
        this.scenario.write("Clear search field");
        searchInput.clear();
        this.scenario.write(String.format("Enter '%s' into search field", searchText));
        searchInput.sendKeys(searchText);
        this.scenario.write("Click on submit button");
        submitButton.click();
        return new WikipediaSearchResultsPage(setupDriverHook);
    }
}
