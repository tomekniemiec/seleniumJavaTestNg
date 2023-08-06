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
}
