package subway.view.constants;

import static subway.view.constants.ErrorMessage.INPUT_INVALID_COMMAND;

import java.util.Arrays;

public enum MainCommand {

    STATION("1"),
    LINE("2"),
    PATH("3"),
    SUBWAY_LINES("4"),
    QUIT("Q");

    private final String key;

    MainCommand(String key) {
        this.key = key;
    }

    public static MainCommand find(String key) {
        return Arrays.stream(values())
                .filter(value -> value.key.equals(key))
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(INPUT_INVALID_COMMAND.getValue());
                });
    }

    public String getKey() {
        return key;
    }
}
