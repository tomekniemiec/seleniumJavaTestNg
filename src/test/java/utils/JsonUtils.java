package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static utils.JsonUtils.JsonPathBuilder.*;

public class JsonUtils {
    private static final String BASE_PATH_TO_DATA_TEST = "src/test/java/dataTest/";

    private static JsonNode readJsonFile(String fileName) throws IOException {
        String json = new String(Files.readAllBytes(Paths.get(fileName)));

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(json);
    }

    public static void main(String[] args) throws IOException {
        JsonUtils jsonUtils = new JsonUtils();
        String value = jsonUtils.verifyEventInJsonStructure(JsonFile.DATA2, EventValue.DL_PROMO_CLICK, pathBuilder(ECOMMERCE, PROMO_CLICK, PROMOTIONS, FIRST_OBJECT, CREATIVE));
        System.out.println(value);

        String value2 = jsonUtils.getJsonData(JsonFile.DATA1, pathBuilder(NAME));
        System.out.println(value2);
    }

    public String verifyEventInJsonStructure(JsonFile pathToJsonEnum, EventValue eventValueEnum, List<JsonPathBuilder> expectedJsonStructure) {
        try {
            JsonNode rootNode = readJsonFile(pathToJsonEnum.toString());

            if (!rootNode.has("event") || !eventValueEnum.toString().equals(rootNode.get("event").asText())) {
                System.out.println("Expected event value '" + eventValueEnum + "' not found.");
                return null;
            }

            for (JsonPathBuilder keyEnum : expectedJsonStructure) {
                String key = keyEnum.toString();
                System.out.println("Searching for key/index: " + key);

                if (rootNode.isArray()) {
                    int index = Integer.parseInt(key);
                    if (index < 0 || index >= rootNode.size()) {
                        System.out.println("Index " + key + " out of range for array.");
                        return null;
                    }
                    rootNode = rootNode.get(index);
                } else if (rootNode.has(key)) {
                    rootNode = rootNode.get(key);
                } else {
                    System.out.println("Key '" + key + "' not found in the JSON structure.");
                    return null;
                }
            }

            return rootNode.asText();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid index value provided in structure.");
        }
        return null;
    }

    public String getJsonData(JsonFile pathToJsonFile, List<JsonPathBuilder> pathList) throws IOException {
        JsonNode json = readJsonFile(pathToJsonFile.toString());

        for (JsonPathBuilder nodeEnum : pathList) {
            String node = nodeEnum.toString();
            if (json == null) {
                return null;
            }
            json = json.path(node);
        }

        return json.asText();
    }

    public enum JsonFile {
        DATA1("data.json"), DATA2("data2.json");

        private final String path;

        JsonFile(String path) {
            this.path = path;
        }

        @Override
        public String toString() {
            return BASE_PATH_TO_DATA_TEST + this.path;
        }
    }

    public enum EventValue {
        DL_PROMO_CLICK("dlPromoClick");

        private final String value;

        EventValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public enum JsonPathBuilder {
        NAME("name"), ECOMMERCE("ecommerce"), PROMO_CLICK("promoClick"), PROMOTIONS("promotions"), POSITIONS("position"), FIRST_OBJECT("0"), CREATIVE("creative");

        private final String value;

        JsonPathBuilder(String value) {
            this.value = value;
        }

        public static List<JsonPathBuilder> pathBuilder(JsonPathBuilder... paths) {
            return Arrays.asList(paths);
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
