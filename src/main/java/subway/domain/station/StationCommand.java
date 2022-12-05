package subway.domain.station;

import java.util.Arrays;

public enum StationCommand {
    ADD_STATION("1"),
    DELETE_STATION("2"),
    SHOW_STATION("3"),
    BACK("B");

    private final String button;

    StationCommand(String button) {
        this.button = button;
    }

    public static StationCommand getCode(String button) {
        return Arrays.stream(values())
                .filter(value -> value.button.equals(button))
                .findAny()
                .orElse(null);
    }
}
