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

public class ProductsPage {

    private Logger logger = LogManager.getLogger(ProductsPage.class);

    @FindBys({@FindBy(xpath = "//div[@class='app_logo']")})
    List<WebElement> logo;

    @FindBys({@FindBy(css = ".pricebar button")})
    List<WebElement> addToCartButtonList;

    @FindBy(css = ".shopping_cart_link")
    WebElement shoppingCartLink;

    public ProductsPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

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
