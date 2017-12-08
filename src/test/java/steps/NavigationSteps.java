package steps;

import cucumber.api.java.en.Given;
import hooks.SetupDriverHook;
import org.openqa.selenium.WebDriver;

public class NavigationSteps {

    private SetupDriverHook setupDriverHook;
    private WebDriver driver;


    public NavigationSteps(SetupDriverHook setupDriverHook) {

        this.setupDriverHook = setupDriverHook;
        this.driver = setupDriverHook.getDriver();
    }

    private enum NavigationLinks {

        HOMEPAGE("http://google.com");
        private String navigationLink;

        private NavigationLinks(String link) {

            navigationLink = link;
        }

        public String getNavigationLink() {

            return navigationLink;
        }
    }


    @Given("^I open (HOMEPAGE) url$")
    public void iOpenHOMEPAGEUrl(NavigationLinks page) throws Throwable {

        driver.get(page.getNavigationLink());
    }

}
