package tests;

import org.testng.annotations.Test;
import pages.objects.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class FailedLoginTest extends TestBase {

    @Test
    public void NegativeLogin() {
        LoginPage loginPage = new LoginPage();
        String errorMessage = loginPage.typeUsername("standard_user")
                .typePassword("secret_sauceaaaaaaaaaaaaaa")
                .clickSubmitLoginButtonWhenFailed()
                .getErrorMessage();
        assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service",
                "Incorrect username or password");
    }

    @Test
    public void NegativeLogin2() {
        LoginPage loginPage = new LoginPage();
        String errorMessage = loginPage.typeUsername("standard_user")
                .typePassword("secret_sauceaaaaaaaaaaaaaa")
                .clickSubmitLoginButtonWhenFailed()
                .getErrorMessage();
        assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service",
                "Incorrect username or password");
    }

    @Test
    public void NegativeLogin3() {
        LoginPage loginPage = new LoginPage();
        String errorMessage = loginPage.typeUsername("standard_user")
                .typePassword("secret_sauceaaaaaaaaaaaaaa")
                .clickSubmitLoginButtonWhenFailed()
                .getErrorMessage();
        assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service",
                "Incorrect username or password");
    }

    @Test
    public void NegativeLogin4() {
        LoginPage loginPage = new LoginPage();
        String errorMessage = loginPage.typeUsername("standard_user")
                .typePassword("secret_sauceaaaaaaaaaaaaaa")
                .clickSubmitLoginButtonWhenFailed()
                .getErrorMessage();
        assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service",
                "Incorrect username or password");
    }

}
