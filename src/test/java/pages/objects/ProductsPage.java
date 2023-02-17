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


    public ProductsPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public boolean isLogoDisplayed() {
        WaitForElement.waitForElementVisible(logo.get(0));
        return logo.size() > 0;
    }


}
