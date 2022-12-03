package subway.view.constants;

public enum Format {

    INFO("[INFO] %s"),
    HEADER("## %s"),
    ERROR("[ERROR] %s"),
    MENU("%s. %s")
    ;

    private final String value;

    Format(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
