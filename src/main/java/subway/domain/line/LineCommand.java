package subway.domain.line;

import java.util.Arrays;

public enum LineCommand {
    ADD_LINE("1"),
    DELETE_LINE("2"),
    SHOW_LINE("3"),
    BACK("B");

    private final String button;

    LineCommand(String button) {
        this.button = button;
    }

    public static LineCommand convertToCommand(String button) {
        return Arrays.stream(values())
                .filter(value -> value.button.equals(button))
                .findAny()
                .orElse(null);
    }
}
