package subway.domain.command;

import java.util.Arrays;

public enum ManageCommand {

    INSERT("1"),
    DELETE("2"),
    READ("3"),
    BACK("B");

    private final String command;

    ManageCommand(String command) {
        this.command = command;
    }

    public static ManageCommand getCommand(String command) {
        return Arrays.stream(values())
                .filter(manageCommand -> command.equals(manageCommand.command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }

}
