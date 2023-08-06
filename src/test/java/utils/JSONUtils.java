package utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONUtils {

    public static <T> boolean hasNestedValue(String jsonString, T valueToCheck, String... nestedFields) {
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(jsonString);

        return checkNestedValue(element, valueToCheck, nestedFields, 0);
    }

    private static <T> boolean checkNestedValue(JsonElement element, T valueToCheck, String[] nestedFields, int index) {
        if (element.isJsonObject()) {
            JsonObject jsonObject = element.getAsJsonObject();

            if (index < nestedFields.length) {
                String nestedField = nestedFields[index];

                if (jsonObject.has(nestedField)) {
                    JsonElement nestedElement = jsonObject.get(nestedField);

                    if (index == nestedFields.length - 1) {
                        return checkValue(nestedElement, valueToCheck);
                    }

                    return checkNestedValue(nestedElement, valueToCheck, nestedFields, index + 1);
                }
            }
        } else if (element.isJsonArray()) {
            JsonArray jsonArray = element.getAsJsonArray();
            int arrayIndex = Integer.parseInt(nestedFields[index]); // Pobieramy indeks tablicy jako liczba całkowita
            JsonElement arrayElement = jsonArray.get(arrayIndex); // Pobieramy odpowiedni element tablicy

            return checkNestedValue(arrayElement, valueToCheck, nestedFields, index + 1);
        }

        return false;
    }

    private static <T> boolean checkValue(JsonElement element, T valueToCheck) {
        if (element.isJsonPrimitive()) {
            return element.getAsString().equals(valueToCheck.toString());
        }
        return false;
    }

    public static void main(String[] args) {
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

        String[] nestedFields1 = {"address", "coordinates", "longitude"};
        boolean hasDesiredValue1 = hasNestedValue(jsonString, "-74.0060", nestedFields1);
        System.out.println("Czy istnieje zagnieżdżenie w kolejności 'address.coordinates.longitude' z wartością -74.0060? " + hasDesiredValue1);

        String[] nestedFields2 = {"orders", "0", "product"};
        boolean hasDesiredValue2 = hasNestedValue(jsonString, "Widget", nestedFields2);
        System.out.println("Czy istnieje zagnieżdżenie w kolejności 'orders[0].product' z wartością 'Widget'? " + hasDesiredValue2);
    }
}
