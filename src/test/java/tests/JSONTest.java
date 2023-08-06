package tests;

import org.testng.annotations.Test;
import utils.Helper;
import utils.JSONUtils;

import static org.testng.Assert.assertTrue;

public class JSONTest extends TestBase {

    String data = Helper.getJsonFile("src/test/java/dataTest/data.json");

    @Test(groups = {"json"})
    public void shouldHasNestedValueForName() {
        String[] nestedFieldsForName = {"name"};
        assertTrue(JSONUtils.hasNestedValue(data, "John Smith", nestedFieldsForName),
                "Does the value 'John Smith' exist in the nested field 'name'?");
    }

    @Test(groups = {"json"})
    public void shouldHasNestedValueForTwitter() {
        String[] nestedFieldsForTwitter = {"contact", "social", "twitter"};
        assertTrue(JSONUtils.hasNestedValue(data, "@johnsmith", nestedFieldsForTwitter),
                "Does the value '@johnsmith' exist in the nested field 'contact.social.twitter'?");
    }

    @Test(groups = {"json"})
    public void shouldHasNestedValueForProduct() {
        String[] nestedFieldsForProduct = {"orders", "0", "product"};
        assertTrue(JSONUtils.hasNestedValue(data, "Widget", nestedFieldsForProduct),
                "Does the value 'Widget' exist in the nested field 'orders[0].product'?");
    }
}