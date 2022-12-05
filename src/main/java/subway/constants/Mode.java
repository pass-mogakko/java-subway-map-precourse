package subway.constants;

import java.util.Arrays;
import subway.controller.function.LineController;
import subway.controller.ManagementController;
import subway.controller.function.RouteMapController;
import subway.controller.function.SectionController;
import subway.controller.function.StationController;
import subway.domain.command.MainCommand;

public enum Mode {

    STATION(new StationController(), MainCommand.STATION),
    LINE(new LineController(), MainCommand.LINE),
    SECTION(new SectionController(), MainCommand.SECTION),
    ROUTE_MAP(new RouteMapController(), MainCommand.ROUTEMAP);

    private ManagementController managementController;
    private MainCommand executeCommand;

    Mode(ManagementController managementController, MainCommand executeCommand) {
        this.managementController = managementController;
        this.executeCommand = executeCommand;
    }

    public static ManagementController findControllerByMainCommand(MainCommand mainCommand) {
        Mode findMode = Arrays.stream(values())
                .filter(mode -> mainCommand.equals(mode.executeCommand))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
        return findMode.managementController;
    }

}