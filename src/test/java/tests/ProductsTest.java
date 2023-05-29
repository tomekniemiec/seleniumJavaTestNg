package tests;

import org.testng.annotations.Test;
import pages.objects.LoginPage;

import static org.testng.Assert.assertEquals;
import static utils.Helper.getLocalStorageSize;


public class ProductsTest extends TestBase {

    @Test
    public void shouldAddProductToCart() {
        LoginPage loginPage = new LoginPage();
        Integer productsInCart = loginPage.logIn()
                .addFirstProductToCart()
                .goToCartPage()
                .getProductNumberInCart();

        assertEquals(productsInCart, 1, "Product should be added to cart");
    }

    @Test
    public void shouldSeeCorrectNumberOfProducts() {
        LoginPage loginPage = new LoginPage();
        Integer numberOfProducts = loginPage.logIn()
                .getProductItemsCount();

        assertEquals(numberOfProducts, 6, "Incorrect number of products");
    }

    @Test
    public void shouldNotSeeProductsInCartAfterLoginByLocalStorage() {
        LoginPage loginPage = new LoginPage();
        loginPage.logIn();

        assertEquals(getLocalStorageSize(), 0, "Incorrect number of products in cart");
    }

    @Test
    public void shouldProductItemsNameContainMoreThan10Char() {
        LoginPage loginPage = new LoginPage();
        int count = loginPage.logIn().getProductItemsNamesAndVerifyCharLength(10);

        assertEquals(count, 6, "Incorrect number of products whose name contains more than 10 characters");
    }

    @Test
    public void shouldProductItemsNameContainTextSauce() {
        LoginPage loginPage = new LoginPage();
        int count = loginPage.logIn().getProductItemsNamesAndVerifyNameContainText("Sauce");

        assertEquals(count, 5, "Incorrect number of products whose name contains 'Sauce'");
    }

    @Test
    public void shouldProductItemsPriceEachOfThemIsGreaterThan5Dollar() {
        LoginPage loginPage = new LoginPage();
        int count = loginPage.logIn().getProductItemsPriceAndCheckIfValueEachOfThemIsGreaterThan(5);

        assertEquals(count, 6, "Incorrect number of products whose price is grater than 5$");
    }

}
