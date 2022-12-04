package subway.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import subway.view.constants.menu.MainCommand;

public enum ControllerHandler {

    STATION(MainCommand.STATION, StationController::selectMenu),
    LINE(MainCommand.LINE, LineController::selectMenu),
    PATH(MainCommand.PATH, PathController::selectMenu),
    SUBWAY_LINES(MainCommand.SUBWAY_LINES, PathController::showAllSubwayLines),
    ;

    private static final Map<MainCommand, Runnable> runnableByMainCommand = Arrays.stream(values()).sequential()
            .collect(Collectors.toMap(value -> value.mainCommand, value -> value.runnable));
    private final MainCommand mainCommand;
    private final Runnable runnable;

    ControllerHandler(MainCommand mainCommand, Runnable runnable) {
        this.mainCommand = mainCommand;
        this.runnable = runnable;
    }

    public static void run(MainCommand command) {
        Runnable controllerMethod = runnableByMainCommand.get(command);
        if (controllerMethod == null) {
            throw new IllegalArgumentException("해당 입력 키워드로 실행할 수 있는 기능이 없습니다.");
        }
        ErrorInterceptor.runUntilGetLegalArguments(controllerMethod);
    }
}
