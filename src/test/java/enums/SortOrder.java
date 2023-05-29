package enums;

public enum SortOrder {
    NAME_FROM_A_TO_Z("az"),
    NAME_FROM_Z_TO_A("za"),
    PRICE_FROM_LO_TO_HI("lohi"),
    PRICE_FROM_HI_TO_LO("hilo");

    private final String value;

    SortOrder(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }


}
