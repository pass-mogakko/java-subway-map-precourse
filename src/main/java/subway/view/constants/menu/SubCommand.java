package subway.view.constants.menu;

import static subway.view.constants.ErrorMessage.INPUT_INVALID_COMMAND;

import java.util.Arrays;

public enum SubCommand {

    CREATE("1"),
    DELETE("2"),
    READ("3"),
    BACK("B");

    private final String key;

    SubCommand(String key) {
        this.key = key;
    }

    public static SubCommand find(String key) {
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
