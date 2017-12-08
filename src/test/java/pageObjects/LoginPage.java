package pageObjects;

import hooks.SetupDriverHook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "input[type=email]")
    private WebElement emailField;

    @FindBy(css = "input[type=password]")
    private WebElement passwordField;

    @FindBy(css = "button[type=submit]")
    private WebElement loginBtn;


    public LoginPage(SetupDriverHook setupDriverHook) {
        super(setupDriverHook);
        assertPageLoaded();

    }


    @Override
    public LoginPage assertPageLoaded() {

        this.scenario.write("Making assertion that I'm on Login Page");
        waitForVisibilityOf(emailField);
        waitForVisibilityOf(passwordField);
        return this;
    }


    public LoginPage enterMail(String mail) {

        this.scenario.write("Entering mail " + mail);
        enterTextInTextField(emailField, mail);
        return this;
    }


    public LoginPage enterPassword(String password) {

        this.scenario.write("Entering password " + password);
        enterTextInTextField(passwordField, password);
        return this;
    }


    public HomePage submitLoginForm() {

        this.scenario.write("Tapping on submit button");
        waitForClickabilityAndClickOn(loginBtn);
        return new HomePage(setupDriverHook);
    }
}
