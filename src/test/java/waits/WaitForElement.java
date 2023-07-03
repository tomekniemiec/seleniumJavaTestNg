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
        WebElement elementVisible = webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        return elementVisible;
    }

    public static WebElement waitUntilElementClickable(WebElement element) {
        WebDriverWait webDriverWait = getWebDriverWait();
        WebElement elementClickable = webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        return elementClickable;
    }

    public static WebElement waitForElementToBeClickable(By by) {
        WebDriverWait webDriverWait = getWebDriverWait();
        WebElement element = webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        return element;
    }
}
