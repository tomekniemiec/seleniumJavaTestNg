package driver;

public enum BrowserType {
    FIREFOX("firefox"),
    SAFARI("safari"),
    CHROME("chrome");

    private final String browser;

    BrowserType(String browser) {
        this.browser = browser;
    }
}
