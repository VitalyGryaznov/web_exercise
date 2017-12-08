package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import models.ConfigModel;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.DataHelper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SetupDriverHook {

    private static WebDriver driver;
    private static ConfigModel configData;
    private Scenario scenario;

    @Before
    public void beforeCallingScenario() throws InstantiationException, MalformedURLException {

        configData = (System.getProperty("configFile") == null || System.getProperty("configFile").equals("")) ?
                DataHelper.getConfigData("localConfig") :
                DataHelper.getConfigData(System.getProperty("configFile"));

        if (configData.getRUN_LOCALLY()) {

            switch (configData.getBROWSER_NAME()) {
                case "Firefox":
                    driver = new FirefoxDriver();
                    break;
                case "Edge":
                    driver = new EdgeDriver();
                    break;
                case "InternetExplorerDriver":
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    if (!configData.getCHROMEDRIVER_PATH().equals("") ) {
                        System.setProperty("webdriver.chrome.driver", configData.getCHROMEDRIVER_PATH());
                    }
                    driver = new ChromeDriver();

            }
        } else {

            DesiredCapabilities capability = new DesiredCapabilities();
            driver = new RemoteWebDriver(new URL("node url"), capability);

        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @After
    public void afterRunningScenario(Scenario scenario) {

        try {
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            }
        } catch (Error | Exception er) {
            er.printStackTrace();
        }

        driver.quit();
        driver = null;
    }

    public WebDriver getDriver() {

        return driver;
    }

    public Scenario getScenario() {

        return this.scenario;
    }

    public void setScenario(Scenario scenario) {

        this.scenario = scenario;
    }

    public ConfigModel getConfigData() {

        return configData;
    }
}
