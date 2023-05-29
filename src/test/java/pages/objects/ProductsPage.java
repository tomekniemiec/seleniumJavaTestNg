package pages.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import waits.WaitForElement;

import java.util.List;

public class ProductsPage extends BasePage {

    @FindBys({@FindBy(xpath = "//div[@class='app_logo']")})
    List<WebElement> logo;

    @FindBys({@FindBy(css = ".pricebar button")})
    List<WebElement> addToCartButtonList;

    @FindBys({@FindBy(css = ".inventory_item")})
    List<WebElement> productItems;

    @FindBys({@FindBy(css = ".inventory_item_name")})
    List<WebElement> productItemsName;

    @FindBys({@FindBy(css = ".inventory_item_price")})
    List<WebElement> productItemsPrice;

    @FindBy(css = ".shopping_cart_link")
    WebElement shoppingCartLink;

    public boolean isLogoDisplayed() {
        WaitForElement.waitForElementVisible(logo.get(0));
        return logo.size() > 0;
    }

    public ProductsPage addFirstProductToCart() {
        WaitForElement.waitUntilElementClickable(addToCartButtonList.get(0));
        addToCartButtonList.get(0).click();
        return this;
    }

    public CartPage goToCartPage() {
        shoppingCartLink.click();
        return new CartPage();
    }

    public Integer getProductItemsCount() {
        WaitForElement.waitUntilElementClickable(productItems.get(0));
        return productItems.size();
    }

    public Integer getProductItemsNamesAndVerifyCharLength(int numberOfChars) {
        WaitForElement.waitUntilElementClickable(productItemsName.get(0));
        int count = (int) productItemsName.stream()
                .map(WebElement::getText)
                .filter(text -> text.length() > numberOfChars)
                .count();
        log().info("Count number items where names has more than " + numberOfChars + " characters: " + count);
        return count;
    }

    public Integer getProductItemsNamesAndVerifyNameContainText(String productName) {
        WaitForElement.waitUntilElementClickable(productItemsName.get(0));
        int count = (int) productItemsName.stream()
                .map(WebElement::getText)
                .filter(text -> text.contains(productName))
                .count();
        log().info("Count number items where names contain text " + productName + " is: " + count);
        return count;
    }

    public Integer getProductItemsPriceAndCheckIfValueEachOfThemIsGreaterThan(int priceOfProduct) {
        WaitForElement.waitUntilElementClickable(productItemsName.get(0));
        int count = (int) productItemsPrice.stream()
                .map(WebElement::getText)
                .map(price -> price.replace("$", ""))
                .mapToDouble(Double::parseDouble)
                .filter(price -> price > priceOfProduct)
                .count();
        log().info("Count number items where price is greater than " + priceOfProduct + " is: " + count);
        return count;
    }
}
