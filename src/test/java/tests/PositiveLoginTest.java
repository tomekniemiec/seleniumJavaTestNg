package tests;

import org.testng.annotations.Test;
import pages.objects.LoginPage;

import static org.testng.Assert.assertTrue;


public class PositiveLoginTest extends TestBase {

    @Test
    public void asUserLoginUsingValidLoginAndPassword1() {
        LoginPage loginPage = new LoginPage();
        boolean isLogoDisplayed = loginPage.logIn()
                .clickSubmitLoginButton()
                .isLogoDisplayed();
        assertTrue(isLogoDisplayed, "Should see logo after correct log in!!!");
    }

    @Test
    public void asUserLoginUsingValidLoginAndPassword2() {
        LoginPage loginPage = new LoginPage();
        boolean isLogoDisplayed = loginPage.logIn()
                .clickSubmitLoginButton()
                .isLogoDisplayed();
        assertTrue(isLogoDisplayed, "Should see logo after correct log in!!!");
    }

    @Test
    public void asUserLoginUsingValidLoginAndPassword3() {
        LoginPage loginPage = new LoginPage();
        boolean isLogoDisplayed = loginPage.logIn()
                .clickSubmitLoginButton()
                .isLogoDisplayed();
        assertTrue(isLogoDisplayed, "Should see logo after correct log in!!!");
    }

    @Test
    public void asUserLoginUsingValidLoginAndPassword4() {
        LoginPage loginPage = new LoginPage();
        boolean isLogoDisplayed = loginPage.logIn()
                .clickSubmitLoginButton()
                .isLogoDisplayed();
        assertTrue(isLogoDisplayed, "Should see logo after correct log in!!!");
    }

}
