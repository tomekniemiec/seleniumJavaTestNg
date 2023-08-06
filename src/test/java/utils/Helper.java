package utils;

import driver.manager.DriverManager;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Helper {

    public static int getLocalStorageSize() {
        WebStorage webStorage = (WebStorage) new Augmenter().augment(DriverManager.getWebDriver());
        return webStorage.getLocalStorage().size();
    }

    public static String getJsonFile(String file)  {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }
}
