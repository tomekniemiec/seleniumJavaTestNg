package tests;

import org.testng.annotations.Test;
import pages.objects.LoginPage;

import static org.testng.Assert.assertTrue;


public class LoginTest extends TestBase {

    @Test
    public void PositiveLogin() {
        LoginPage loginPage = new LoginPage();
        boolean isLogoDisplayed = loginPage.typeUsername("standard_user")
                .typePassword("secret_sauce")
                .clickSubmitLoginButton()
                .isLogoDisplayed();
        assertTrue(isLogoDisplayed, "Should see logo after correct log in!!!");
    }

}
