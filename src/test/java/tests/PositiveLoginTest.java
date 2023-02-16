package tests;

import org.testng.annotations.Test;
import pages.objects.LoginPage;

import static org.testng.Assert.assertTrue;


public class PositiveLoginTest extends TestBase {
    LoginPage loginPage = new LoginPage();

    @Test
    public void asUserLoginUsingValidLoginAndPassword1() {
        boolean isLogoDisplayed = loginPage.typeUsername("standard_user")
                .typePassword("secret_sauce")
                .clickSubmitLoginButton()
                .isLogoDisplayed();
        assertTrue(isLogoDisplayed, "Should see logo after correct log in!!!");
    }

    @Test
    public void asUserLoginUsingValidLoginAndPassword2() {
        boolean isLogoDisplayed = loginPage.typeUsername("standard_user")
                .typePassword("secret_sauce")
                .clickSubmitLoginButton()
                .isLogoDisplayed();
        assertTrue(isLogoDisplayed, "Should see logo after correct log in!!!");
    }

    @Test
    public void asUserLoginUsingValidLoginAndPassword3() {
        boolean isLogoDisplayed = loginPage.typeUsername("standard_user")
                .typePassword("secret_sauce")
                .clickSubmitLoginButton()
                .isLogoDisplayed();
        assertTrue(isLogoDisplayed, "Should see logo after correct log in!!!");
    }

    @Test
    public void asUserLoginUsingValidLoginAndPassword4() {
        boolean isLogoDisplayed = loginPage.typeUsername("standard_user")
                .typePassword("secret_sauce")
                .clickSubmitLoginButton()
                .isLogoDisplayed();
        assertTrue(isLogoDisplayed, "Should see logo after correct log in!!!");
    }

}
