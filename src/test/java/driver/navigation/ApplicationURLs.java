package driver.navigation;

import configuration.ConfigurationProperties;

public class ApplicationURLs {
    public static final String APPLICATION_URL = ConfigurationProperties.getProperties().getProperty("app.url");
    public static final String APPLICATION_API_URL = ConfigurationProperties.getProperties().getProperty("app.api.url");

}
