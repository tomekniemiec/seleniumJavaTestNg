package pages.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;
import waits.WaitForElement;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends BasePage {

    @FindBys({@FindBy(xpath = "//div[@class='app_logo']")})
    List<WebElement> logo;

    @FindBys({@FindBy(css = ".pricebar button")})
    List<WebElement> addToCartButtonList;

    @FindBys({@FindBy(css = ".inventory_item")})
    List<WebElement> productItems;

    @FindBys({@FindBy(css = ".inventory_item_name")})
    List<WebElement> productsName;

    @FindBys({@FindBy(css = ".inventory_item_price")})
    List<WebElement> productItemsPrice;

    @FindBy(css = ".shopping_cart_link")
    WebElement shoppingCartLink;

    @FindBy(css = ".product_sort_container")
    WebElement dropdownElement;

    public boolean isLogoDisplayed() {
        WaitForElement.waitForElementVisible(logo.get(0));
        return logo.size() > 0;
    }

    public ProductsPage addFirstProductToCart() {
        WaitForElement.waitUntilElementClickable(addToCartButtonList.get(0));
        addToCartButtonList.get(0).click();
        return this;
    }

    public ProductsPage addAllProductsToCart() {
        WaitForElement.waitUntilElementClickable(addToCartButtonList.get(0));
        addToCartButtonList.forEach(WebElement::click);
        return this;
    }

    public ProductsPage setOrderPriceFromLoToHi() {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue("lohi");
        return this;
    }
    public ProductsPage setOrderNameFromAToZ() {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue("az");
        return this;
    }

    public CartPage goToCartPage() {
        shoppingCartLink.click();
        return new CartPage();
    }

    public Integer getProductCount() {
        WaitForElement.waitUntilElementClickable(productItems.get(0));
        return productItems.size();
    }

    public Integer getProductNamesAndVerifyCharLength(int numberOfChars) {
        WaitForElement.waitUntilElementClickable(productsName.get(0));
        int count = (int) productsName.stream()
                .map(WebElement::getText)
                .filter(text -> text.length() > numberOfChars)
                .count();
        log().info("Count number items where names has more than " + numberOfChars + " characters: " + count);
        return count;
    }

    public Integer getProductNamesAndVerifyNameContainText(String productName) {
        WaitForElement.waitUntilElementClickable(productsName.get(0));
        int count = (int) productsName.stream()
                .map(WebElement::getText)
                .filter(text -> text.contains(productName))
                .count();
        log().info("Count number items where names contain text " + productName + " is: " + count);
        return count;
    }

    public Integer getProductPriceAndCheckIfValueEachOfThemIsGreaterThan(int priceOfProduct) {
        WaitForElement.waitUntilElementClickable(productsName.get(0));
        int count = (int) productItemsPrice.stream()
                .map(WebElement::getText)
                .map(price -> price.replace("$", ""))
                .mapToDouble(Double::parseDouble)
                .filter(price -> price > priceOfProduct)
                .count();
        log().info("Count number items where price is greater than " + priceOfProduct + " is: " + count);
        return count;
    }

    public boolean getProductPriceAndCheckIfNextProductHasHigherPrice() {
        WaitForElement.waitUntilElementClickable(productsName.get(0));
        List<Double> prices = productItemsPrice.stream()
                        .map(product -> {
                            String priceText = product.getText().replace("$", "");
                            return Double.parseDouble(priceText);
                        })
                .collect(Collectors.toList());
        double firstPrice = prices.get(0);
        return prices.stream()
                .skip(1)
                .allMatch(price -> price >= firstPrice);
    }

    public boolean getProductNamesAndCheckIfIsSortFromAtoZ() {
        WaitForElement.waitUntilElementClickable(productsName.get(0));
        List<String> productNames = productsName.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> sortedProducts = productsName.stream()
                .map(WebElement::getText)
                .sorted()
                .collect(Collectors.toList());

        return productNames.equals(sortedProducts);
    }
}
