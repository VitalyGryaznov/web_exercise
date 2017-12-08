package pageObjects;

import hooks.SetupDriverHook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = ".nav-but")
    private WebElement hamburgerMenu;

    @FindBy(css = "div[ng-click$=\"logOut()\"]")
    private WebElement logOutIcon;

    public HomePage(SetupDriverHook setupDriverHook) {

        super(setupDriverHook);
        assertPageLoaded();
    }


    @Override
    public HomePage assertPageLoaded() {

        this.scenario.write("Making assertion that I'm on Home Page");
        waitForVisibilityOf(hamburgerMenu);
        waitForVisibilityOf(logOutIcon);
        return this;
    }

}
