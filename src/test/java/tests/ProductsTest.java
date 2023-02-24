package tests;

import org.testng.annotations.Test;
import pages.objects.LoginPage;

import static org.testng.Assert.assertEquals;


public class ProductsTest extends TestBase {

    @Test
    public void addProductToCart() {
        LoginPage loginPage = new LoginPage();
        Integer productsInCart = loginPage.typeUsername("standard_user")
                .typePassword("secret_sauce")
                .clickSubmitLoginButton()
                .addFirstProductToCart()
                .goToCartPage()
                .getProductNumberInCart();

        assertEquals(productsInCart, 1, "Product should be added to cart");
    }

}
