package subway.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import subway.view.constants.menu.MainCommand;

public enum FirstControllerHandler {
    STATION(MainCommand.STATION, StationController.getInstance()),
    LINE(MainCommand.LINE, LineController.getInstance()),
    PATH(MainCommand.PATH, PathController.getInstance()),
    SUBWAY_LINES(MainCommand.SUBWAY_LINES, SubWayLinesController.getInstance()),
    ;

    private static final Map<MainCommand, Controller> controllerByCommand = Arrays.stream(values())
            .collect(Collectors.toMap(value -> value.mainCommand, value -> value.controller));
    private final MainCommand mainCommand;
    private final Controller controller;

    FirstControllerHandler(MainCommand mainCommand, Controller controller) {
        this.mainCommand = mainCommand;
        this.controller = controller;
    }

    public static void executeController(MainCommand command) {
        Controller selectedController = controllerByCommand.get(command);
        if (selectedController == null) {
            throw new IllegalArgumentException("해당 입력 키워드로 실행할 수 있는 기능이 없습니다.");
        }
        ErrorInterceptor.repeatUntilNoArgumentException(selectedController, Controller::execute);
    }
}
