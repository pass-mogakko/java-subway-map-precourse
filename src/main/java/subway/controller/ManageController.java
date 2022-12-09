package subway.controller;

import java.util.Arrays;
import subway.Constants;
import subway.command.MainCommand;



public enum ManageController {
    STATION(MainCommand.STATION, new StationController()),
    LINE(MainCommand.LINE, new LineController()),
    ROUTE(MainCommand.ROUTE, new RouteController()),
    SHOW(MainCommand.SHOW, new ShowController());

    private final MainCommand command;
    private final Controllable controllable;

    ManageController(MainCommand command, Controllable controllable) {
        this.command = command;
        this.controllable = controllable;
    }

    public static Controllable getController(MainCommand inputCommand) {
        ManageController manageController = Arrays.stream(ManageController.values())
                .filter(controller -> inputCommand.equals(controller.command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(Constants.ERROR_PREFIX + "존재하지 않는 명령입니다."));

        return manageController.controllable;
    }

}
