package pages.objects;

import configuration.UserProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

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
        log("Entering username: " + user);
        WaitForElement.waitForElementVisible(userName);
        userName.sendKeys(user);
        return this;
    }

    public LoginPage typePassword(String pass) {
        log("Entering password: " + pass);
        password.sendKeys(pass);
        return this;
    }

    public LoginPage logIn() {
        userName.sendKeys(UserProperties.getUsernameStandard());
        password.sendKeys(UserProperties.getPasswordValid());
        return this;
    }

    public LoginPage logIn(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return this;
    }

    public ProductsPage clickSubmitLoginButton() {
        log("Clicking submit login button");
        WaitForElement.waitUntilElementClickable(submitLoginButton);
        submitLoginButton.click();
        return new ProductsPage();
    }

    public LoginPage clickSubmitLoginButtonWhenFailed() {
        log("Clicking submit login button");
        WaitForElement.waitUntilElementClickable(submitLoginButton);
        submitLoginButton.click();
        return this;
    }

    public String getErrorMessage() {
        return getErrorMessage.getText();
    }
}
