package pages.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import waits.WaitForElement;

import java.util.List;

public class CartPage extends BasePage {

    @FindBys({@FindBy(css = ".cart_item")})
    List<WebElement> cartItems;

    @FindBys({@FindBy(xpath = "//button[text()='Remove']")})
    List<WebElement> removeButtons;

    public int getProductNumberInCart() {
        if (!cartItems.isEmpty()) {
            WaitForElement.waitUntilElementClickable(cartItems.get(0));
        }
        return cartItems.size();
    }

    public CartPage removeAllProducts() {
        removeButtons.forEach(WebElement::click);
        return this;
    }

}
