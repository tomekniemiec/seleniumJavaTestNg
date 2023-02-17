package tests;

import org.testng.annotations.Test;
import pages.objects.LoginPage;

import static org.testng.Assert.assertEquals;


public class FailedLoginTest extends TestBase {


    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword1() {
        LoginPage loginPage = new LoginPage();
        String errorMessage = loginPage.typeUsername("standard_user")
                .typePassword("secret_sauceaaaaaaaaaaaaaa")
                .clickSubmitLoginButtonWhenFailed()
                .getErrorMessage();
        assertEquals(errorMessage, "incorrect msg to take a screenshot when test failed",
                "Incorrect username or password");
    }

    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword2() {
        LoginPage loginPage = new LoginPage();
        String errorMessage = loginPage.typeUsername("standard_user")
                .typePassword("secret_sauceaaaaaaaaaaaaaa")
                .clickSubmitLoginButtonWhenFailed()
                .getErrorMessage();
        assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service",
                "Incorrect username or password");
    }

    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword3() {
        LoginPage loginPage = new LoginPage();
        String errorMessage = loginPage.typeUsername("standard_user")
                .typePassword("secret_sauceaaaaaaaaaaaaaa")
                .clickSubmitLoginButtonWhenFailed()
                .getErrorMessage();
        assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service",
                "Incorrect username or password");
    }

    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword4() {
        LoginPage loginPage = new LoginPage();
        String errorMessage = loginPage.typeUsername("standard_user")
                .typePassword("secret_sauceaaaaaaaaaaaaaa")
                .clickSubmitLoginButtonWhenFailed()
                .getErrorMessage();
        assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service",
                "Incorrect username or password");
    }

}
