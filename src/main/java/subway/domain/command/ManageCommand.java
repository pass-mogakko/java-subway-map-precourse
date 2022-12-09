package subway.domain.command;

import java.util.Arrays;
import java.util.function.Consumer;
import subway.controller.ManagementController;

public enum ManageCommand {

    INSERT("1", controller -> controller.insert()),
    DELETE("2", controller -> controller.delete()),
    READ("3", controller -> controller.read()),
    BACK("B", (a) -> System.out.println("dd"));

    private final String command;
    private final Consumer<ManagementController> controller;

    ManageCommand(String command, Consumer<ManagementController> controller) {
        this.command = command;
        this.controller = controller;
    }

    public static ManageCommand getCommand(String command) {
        return Arrays.stream(values())
                .filter(manageCommand -> command.equals(manageCommand.command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public void executeByCommand(ManagementController managementController) {
        controller.accept(managementController);
    }

}
