package subway;


public enum Prefix {
    INFO("[INFO]"),
    ERROR("[ERROR]");

    private final String prefix;

    Prefix(String prefix) {
        this.prefix = prefix;
    }
}
