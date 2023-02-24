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


}
