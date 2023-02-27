package configuration;

public class UserProperties {

    public static String getUsernameStandard() {
        return ConfigurationProperties.getProperties().getProperty("username_standard");
    }

    public static String getPasswordValid() {
        return ConfigurationProperties.getProperties().getProperty("password_valid");
    }

}