package subway.domain.global;

import java.util.Arrays;

public enum SystemCommand {
    STATION_MANAGEMENT("1"),
    LINE_MANAGEMENT("2"),
    SECTION_MANAGEMENT("3"),
    SHOW_LINE_SECTION_MAP("4"),
    QUIT("Q");

    private final String button;

    SystemCommand(String button) {
        this.button = button;
    }

    public static SystemCommand convertToCommand(String button) {
        return Arrays.stream(values())
                .filter(value -> value.button.equals(button))
                .findAny()
                .orElse(null);
    }
}
