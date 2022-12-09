package subway.domain.command;

import java.util.Arrays;

public enum MainCommand {

    STATION("1"),
    LINE("2"),
    SECTION("3"),
    ROUTEMAP("4"),
    QUIT("Q");

    private final String command;

    MainCommand(String command) {
        this.command = command;
    }

    public static MainCommand getCommand(String command) {
        return Arrays.stream(values())
                .filter(mainCommand -> command.equals(mainCommand.command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }


}
