package tests;

import org.testng.annotations.Test;
import pages.objects.LoginPage;

import static org.testng.Assert.assertTrue;


public class PositiveLoginTest extends TestBase {

    @Test
    public void PositiveLogin() {
        LoginPage loginPage = new LoginPage();
        boolean isLogoDisplayed = loginPage.typeUsername("standard_user")
                .typePassword("secret_sauce")
                .clickSubmitLoginButton()
                .isLogoDisplayed();
        assertTrue(isLogoDisplayed, "Should see logo after correct log in!!!");
    }

    @Test
    public void PositiveLogin2() {
        LoginPage loginPage = new LoginPage();
        boolean isLogoDisplayed = loginPage.typeUsername("standard_user")
                .typePassword("secret_sauce")
                .clickSubmitLoginButton()
                .isLogoDisplayed();
        assertTrue(isLogoDisplayed, "Should see logo after correct log in!!!");
    }

    @Test
    public void PositiveLogin3() {
        LoginPage loginPage = new LoginPage();
        boolean isLogoDisplayed = loginPage.typeUsername("standard_user")
                .typePassword("secret_sauce")
                .clickSubmitLoginButton()
                .isLogoDisplayed();
        assertTrue(isLogoDisplayed, "Should see logo after correct log in!!!");
    }

    @Test
    public void PositiveLogin4() {
        LoginPage loginPage = new LoginPage();
        boolean isLogoDisplayed = loginPage.typeUsername("standard_user")
                .typePassword("secret_sauce")
                .clickSubmitLoginButton()
                .isLogoDisplayed();
        assertTrue(isLogoDisplayed, "Should see logo after correct log in!!!");
    }

}
