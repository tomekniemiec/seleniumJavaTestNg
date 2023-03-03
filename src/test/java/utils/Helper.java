package utils;

import driver.manager.DriverManager;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;

public class Helper {

    public static int getLocalStorageSize() {
        WebStorage webStorage = (WebStorage) new Augmenter().augment(DriverManager.getWebDriver());
        return webStorage.getLocalStorage().size();
    }
}
