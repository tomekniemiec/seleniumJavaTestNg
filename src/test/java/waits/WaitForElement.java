package waits;

import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitForElement {

    private static WebDriverWait getWebDriverWait() {
        return new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(10));
    }

    public static WebElement waitForElementVisible(WebElement element) {
        WebDriverWait webDriverWait = getWebDriverWait();
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitUntilElementClickable(WebElement element) {
        WebDriverWait webDriverWait = getWebDriverWait();
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForElementToBeClickable(By by) {
        WebDriverWait webDriverWait = getWebDriverWait();
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }
}
