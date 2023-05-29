package tests;

import org.testng.annotations.Test;
import pages.objects.LoginPage;

import static configuration.UserProperties.getPasswordInvalid;
import static configuration.UserProperties.getUsernameStandard;
import static org.testng.Assert.assertEquals;


public class FailedLoginTest extends TestBase {

    String MESSAGE_INCORRECT_USER_AND_PASSWORD = "Epic sadface: Username and password do not match any user in this service";

    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword1() {
        LoginPage loginPage = new LoginPage();
        String errorMessage = loginPage.logIn(getUsernameStandard(), getPasswordInvalid())
                .clickSubmitLoginButtonWhenFailed()
                .getErrorMessage();
        assertEquals(errorMessage, MESSAGE_INCORRECT_USER_AND_PASSWORD,
                "Incorrect username or password");
    }

    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword2() {
        LoginPage loginPage = new LoginPage();
        String errorMessage = loginPage.logIn(getUsernameStandard(), getPasswordInvalid())
                .clickSubmitLoginButtonWhenFailed()
                .getErrorMessage();
        assertEquals(errorMessage, MESSAGE_INCORRECT_USER_AND_PASSWORD,
                "Incorrect username or password");
    }

    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword3() {
        LoginPage loginPage = new LoginPage();
        String errorMessage = loginPage.logIn(getUsernameStandard(), getPasswordInvalid())
                .clickSubmitLoginButtonWhenFailed()
                .getErrorMessage();
        assertEquals(errorMessage, MESSAGE_INCORRECT_USER_AND_PASSWORD,
                "Incorrect username or password");
    }

    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword4() {
        LoginPage loginPage = new LoginPage();
        String errorMessage = loginPage.logIn(getUsernameStandard(), getPasswordInvalid())
                .clickSubmitLoginButtonWhenFailed()
                .getErrorMessage();
        assertEquals(errorMessage, MESSAGE_INCORRECT_USER_AND_PASSWORD,
                "Incorrect username or password");
    }

}
