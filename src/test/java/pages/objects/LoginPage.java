package pages.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage {

    Logger logger = LogManager.getRootLogger();

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement submitLoginButton;

    @FindBy(className = "error-message-container")
    private WebElement getErrorMessage;


    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public LoginPage typeUsername(String user) {
        logger.info("Entering username: " + user);
        WaitForElement.waitForElementVisible(userName);
        userName.sendKeys(user);
        return this;
    }

    public LoginPage typePassword(String pass) {
        logger.info("Entering password: xxxxxx");
        password.sendKeys(pass);
        return this;
    }

    public ProductsPage clickSubmitLoginButton() {
        logger.info("Clicking submit login button");
        WaitForElement.waitUntilElementClickable(submitLoginButton);
        submitLoginButton.click();
        return new ProductsPage();
    }

    public LoginPage clickSubmitLoginButtonWhenFailed() {
        logger.info("Clicking submit login button");
        WaitForElement.waitUntilElementClickable(submitLoginButton);
        submitLoginButton.click();
        return this;
    }

    public String getErrorMessage() {
        return getErrorMessage.getText();
    }
}
