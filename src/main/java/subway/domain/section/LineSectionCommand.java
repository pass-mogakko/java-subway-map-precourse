package subway.domain.section;

import java.util.Arrays;

public enum LineSectionCommand {
    ADD_SECTION("1"),
    DELETE_SECTION("2"),
    BACK("B");

    private final String button;

    LineSectionCommand(String button) {
        this.button = button;
    }

    public static LineSectionCommand getCode(String button) {
        return Arrays.stream(values())
                .filter(value -> value.button.equals(button))
                .findAny()
                .orElse(null);
    }
}
