package driver;

import configuration.TestRunProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {

    private static final String MESSAGE_UNKNOWN_BROWSER = "Unknown browser type! Please check your configuration";
    private final BrowserType browserType;
    private final boolean isRemoteRun;

    public BrowserFactory(BrowserType browserType, boolean isRemoteRun) {
        this.browserType = browserType;
        this.isRemoteRun = isRemoteRun;
    }

    public WebDriver getBrowser() {

        if (isRemoteRun) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            switch (browserType) {
                case CHROME:
                    ChromeOptions co = new ChromeOptions();
                    co.addArguments("--remote-allow-origins=*");
                    if (TestRunProperties.getHeadlessModeToRun()) {
                        co.addArguments("--headless");
                    }
                    desiredCapabilities.setBrowserName((Browser.CHROME.browserName()));
                    desiredCapabilities.setVersion("115");
                    desiredCapabilities.merge(co);
                    return getRemoteWebDriver(desiredCapabilities);
                case FIREFOX:
                    FirefoxOptions fo = new FirefoxOptions();
                    fo.addArguments("--remote-allow-origins=*");
                    if (TestRunProperties.getHeadlessModeToRun()) {
                        fo.addArguments("--headless");
                    }
                    desiredCapabilities.merge(fo);
                    return getRemoteWebDriver(desiredCapabilities);
                default:
                    throw new IllegalStateException(MESSAGE_UNKNOWN_BROWSER);
            }
        } else {
            switch (browserType) {
                case CHROME:
                    ChromeOptions co = new ChromeOptions();
                    co.addArguments("--remote-allow-origins=*");
                    if (TestRunProperties.getHeadlessModeToRun()) {
                        co.addArguments("--headless");
                    }
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver(co);
                case FIREFOX:
                    FirefoxOptions fo = new FirefoxOptions();
                    fo.addArguments("--remote-allow-origins=*");
                    if (TestRunProperties.getHeadlessModeToRun()) {
                        fo.addArguments("--headless");
                    }
                    return new FirefoxDriver(fo);
                default:
                    throw new IllegalStateException(MESSAGE_UNKNOWN_BROWSER);
            }
        }
    }

    private WebDriver getRemoteWebDriver(DesiredCapabilities desiredCapabilities) {
        RemoteWebDriver remoteWebDriver;

        try {
            remoteWebDriver = new RemoteWebDriver(new URL(TestRunProperties.getGridUrl()), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create RemoteWebDriver due to: " + e.getMessage());
        }
        return remoteWebDriver;
    }
}