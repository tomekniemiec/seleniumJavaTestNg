package tests;

import configuration.ConfigurationProperties;
import configuration.PropertiesLoader;
import driver.BrowserType;
import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.Properties;

import static driver.navigation.ApplicationURLs.APPLICATION_URL;

public class TestBase {

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void beforeTest(@Optional BrowserType browserType) {
        DriverManager.setWebDriver(browserType);
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(ITestResult result) {
        DriverManager.disposeDriver();
    }


}