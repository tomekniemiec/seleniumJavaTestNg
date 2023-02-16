package configuration;

import java.util.Properties;

public class ConfigurationProperties {
    private static Properties properties;

    private ConfigurationProperties() {

    }

    public static Properties getProperties() {
        if (properties == null) {
            throw new IllegalStateException("Please set properties using setProperties() before calling getProperties()");
        }
        return properties;
    }

    public static void setProperties(Properties properties) {
        ConfigurationProperties.properties = properties;
    }
}
