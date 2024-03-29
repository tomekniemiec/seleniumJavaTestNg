package pages.objects;

import configuration.UserProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static waits.WaitForElement.*;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement submitLoginButton;

    @FindBy(className = "error-message-container")
    private WebElement getErrorMessage;

    public LoginPage typeUsername(String user) {
        log().info("Entering username: " + user);
        waitForElementVisible(userName).sendKeys(user);
        return this;
    }

    public LoginPage typePassword(String pass) {
        log().info("Entering password: " + pass);
        password.sendKeys(pass);
        return this;
    }

    public ProductsPage logIn() {
        userName.sendKeys(UserProperties.getUsernameStandard());
        password.sendKeys(UserProperties.getPasswordValid());
        clickSubmitLoginButton();
        return new ProductsPage();
    }

    public LoginPage logIn(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return this;
    }

    public ProductsPage clickSubmitLoginButton() {
        log().info("Clicking submit login button");
        waitUntilElementClickable(submitLoginButton).click();
        return new ProductsPage();
    }

    public LoginPage clickSubmitLoginButtonWhenFailed() {
        log().info("Clicking submit login button");
        waitUntilElementClickable(submitLoginButton).click();

        return this;
    }

    public String getErrorMessage() {
        return getErrorMessage.getText();
    }
}
