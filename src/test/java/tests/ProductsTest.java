package tests;

import org.testng.annotations.Test;
import pages.objects.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
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
    public void shouldRemoveProductFromCart() {
        LoginPage loginPage = new LoginPage();
        Integer productsInCart = loginPage.logIn()
                .addFirstProductToCart()
                .goToCartPage()
                .removeAllProducts()
                .getProductNumberInCart();

        assertEquals(productsInCart, 0, "Product should be removed to cart");
    }

    @Test
    public void shouldSeeCorrectNumberOfProducts() {
        LoginPage loginPage = new LoginPage();
        Integer numberOfProducts = loginPage.logIn()
                .getProductCount();

        assertEquals(numberOfProducts, 6, "Incorrect number of products");
    }

    @Test
    public void shouldNotSeeProductsInCartAfterLoginByLocalStorage() {
        LoginPage loginPage = new LoginPage();
        loginPage.logIn();

        assertEquals(getLocalStorageSize(), 0, "Incorrect number of products in cart");
    }

    @Test
    public void shouldProductNameContainMoreThan10Char() {
        LoginPage loginPage = new LoginPage();
        int count = loginPage.logIn().getProductNamesAndVerifyCharLength(10);

        assertEquals(count, 6, "Incorrect number of products whose name contains more than 10 characters");
    }

    @Test
    public void shouldProductNameContainTextSauce() {
        LoginPage loginPage = new LoginPage();
        int count = loginPage.logIn().getProductNamesAndVerifyNameContainText("Sauce");

        assertEquals(count, 5, "Incorrect number of products whose name contains 'Sauce'");
    }

    @Test
    public void shouldProductPriceEachOfThemIsGreaterThan5Dollar() {
        LoginPage loginPage = new LoginPage();
        int count = loginPage.logIn().getProductPriceAndCheckIfValueEachOfThemIsGreaterThan(5);

        assertEquals(count, 6, "Incorrect number of products whose price is grater than 5$");
    }

    @Test
    public void shouldNextProductHasHigherPriceWhenOrderFromLoToHi() {
        LoginPage loginPage = new LoginPage();
        boolean isHigherPrice = loginPage.logIn()
                .setOrderPriceFromLoToHi()
                .getProductPriceAndCheckIfNextProductHasHigherPrice();

        assertTrue(isHigherPrice, "Incorrect sorting by price from lowest to highest");
    }


    @Test
    public void shouldSortProductsNamesFromAtoZ() {
        LoginPage loginPage = new LoginPage();
        boolean isHigherPrice = loginPage.logIn()
                .setOrderNameFromAToZ()
                .getProductNamesAndCheckIfIsSortFromAtoZ();

        assertTrue(isHigherPrice, "Incorrect sorting by name from A to Z");
    }

}
