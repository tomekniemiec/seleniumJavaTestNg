package tests;

import enums.SortOrder;
import org.testng.annotations.Test;
import pages.objects.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.Helper.getLocalStorageSize;


public class ProductsTest extends TestBase {

    @Test(groups = {"product"})
    public void shouldAddProductToCart() {
        LoginPage loginPage = new LoginPage();
        Integer productsInCart = loginPage.logIn()
                .addFirstProductToCart()
                .goToCartPage()
                .getProductNumberInCart();

        assertEquals(productsInCart, 1, "Product should be added to cart");
    }

    @Test(groups = {"product"})
    public void shouldAddFewProductsToCart() {
        LoginPage loginPage = new LoginPage();
        Integer productsInCart = loginPage.logIn()
                .addAllProductsToCart()
                .goToCartPage()
                .getProductNumberInCart();

        assertEquals(productsInCart, 6, "Product should be added to cart");
    }

    @Test(groups = {"product"})
    public void shouldRemoveProductFromCart() {
        LoginPage loginPage = new LoginPage();
        Integer productsInCart = loginPage.logIn()
                .addFirstProductToCart()
                .goToCartPage()
                .removeAllProducts()
                .getProductNumberInCart();

        assertEquals(productsInCart, 0, "Product should be removed to cart");
    }

    @Test(groups = {"product"})
    public void shouldSeeCorrectNumberOfProducts() {
        LoginPage loginPage = new LoginPage();
        Integer numberOfProducts = loginPage.logIn()
                .getProductCount();

        assertEquals(numberOfProducts, 6, "Incorrect number of products");
    }

    @Test(groups = {"product"})
    public void shouldNotSeeProductsInCartAfterLoginByLocalStorage() {
        LoginPage loginPage = new LoginPage();
        loginPage.logIn();

        assertEquals(getLocalStorageSize(), 0, "Incorrect number of products in cart");
    }

    @Test(groups = {"product"})
    public void shouldProductNameContainMoreThan10Char() {
        LoginPage loginPage = new LoginPage();
        int count = loginPage.logIn().getProductNamesAndVerifyCharLength(10);

        assertEquals(count, 6, "Incorrect number of products whose name contains more than 10 characters");
    }

    @Test(groups = {"product"})
    public void shouldProductNameContainTextSauce() {
        LoginPage loginPage = new LoginPage();
        int count = loginPage.logIn().getProductNamesAndVerifyNameContainText("Sauce");

        assertEquals(count, 5, "Incorrect number of products whose name contains 'Sauce'");
    }

    @Test(groups = {"product"})
    public void shouldProductPriceEachOfThemIsGreaterThan5Dollar() {
        LoginPage loginPage = new LoginPage();
        int count = loginPage.logIn().getProductPriceAndCheckIfValueEachOfThemIsGreaterThan(5);

        assertEquals(count, 6, "Incorrect number of products whose price is grater than 5$");
    }

    @Test(groups = {"product"})
    public void shouldSortProductsPriceFromLoToHi() {
        LoginPage loginPage = new LoginPage();
        boolean isHigherPrice = loginPage.logIn()
                .setSortOrderBy(SortOrder.PRICE_FROM_LO_TO_HI.value())
                .getProductPriceAndCheckIfNextProductHasHigherPrice();

        assertTrue(isHigherPrice, "Incorrect sorting by price from lowest to highest");
    }


    @Test(groups = {"product"})
    public void shouldSortProductsNamesFromAtoZ() {
        LoginPage loginPage = new LoginPage();
        boolean isHigherPrice = loginPage.logIn()
                .setSortOrderBy(SortOrder.NAME_FROM_A_TO_Z.value())
                .getProductsNameAndCheckIfIsSortFromAtoZ();

        assertTrue(isHigherPrice, "Incorrect sorting by name from A to Z");
    }

}
