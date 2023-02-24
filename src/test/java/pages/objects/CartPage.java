package pages.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

import java.util.List;

public class CartPage {

    @FindBys({@FindBy(css = ".cart_item")})
    List<WebElement> cartItems;

    private Logger logger = LogManager.getLogger(CartPage.class);

    public CartPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public int getProductNumberInCart() {
        WaitForElement.waitUntilElementClickable(cartItems.get(0));
        return cartItems.size();
    }

}
