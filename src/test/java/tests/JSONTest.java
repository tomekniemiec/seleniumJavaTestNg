package tests;

import org.testng.annotations.Test;
import utils.JSONUtils;

import static org.testng.Assert.assertTrue;

public class JSONTest extends TestBase {

    @Test(groups = {"json"})
    public void shouldHasNestedValue() {
        String jsonString = "{\n" +
                "  \"name\": \"John Smith\",\n" +
                "  \"age\": 30,\n" +
                "  \"address\": {\n" +
                "    \"street\": \"123 Main Street\",\n" +
                "    \"city\": \"Exampletown\",\n" +
                "    \"zip\": \"54321\",\n" +
                "    \"country\": \"USA\",\n" +
                "    \"coordinates\": {\n" +
                "      \"latitude\": 40.7128,\n" +
                "      \"longitude\": -74.0060\n" +
                "    }\n" +
                "  },\n" +
                "  \"contact\": {\n" +
                "    \"email\": \"john.smith@example.com\",\n" +
                "    \"phone\": \"+1 555-123-4567\",\n" +
                "    \"social\": {\n" +
                "      \"twitter\": \"@johnsmith\",\n" +
                "      \"linkedin\": \"john.smith\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"orders\": [\n" +
                "    {\n" +
                "      \"id\": \"12345\",\n" +
                "      \"product\": \"Widget\",\n" +
                "      \"quantity\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"67890\",\n" +
                "      \"product\": \"Gadget\",\n" +
                "      \"quantity\": 1\n" +
                "    }\n" +
                "  ]\n" +
                "}\n";

        String[] nestedFields = {"orders", "0", "product"};
        boolean hasDesiredValue = JSONUtils.hasNestedValue(jsonString, "Widget", nestedFields);

        assertTrue(hasDesiredValue, "Does the value 'Widget' exist in the nested field 'orders[0].product'?");

    }
}