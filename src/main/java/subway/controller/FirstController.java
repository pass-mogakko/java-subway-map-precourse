package subway.controller;

import static subway.controller.RunStatus.RUNNING;
import static subway.controller.RunStatus.STOPPED;
import static subway.view.constants.menu.MainCommand.QUIT;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.constants.menu.MainCommand;

public class FirstController implements Controller {
    private static FirstController instance;
    private RunStatus runStatus = RUNNING;

    private FirstController() {
    }

    public static FirstController getInstance() {
        if (instance == null) {
            instance = new FirstController();
        }
        return instance;
    }

    @Override
    public void execute() {
        try {
            if (runStatus == STOPPED) {
                return;
            }
            ErrorInterceptor.runUntilGetLegalArguments(this::selectMainMenu);
            execute();
        } catch (Exception exception) {
            OutputView.printErrorMessage(exception.getMessage());
        }
    }

    private void selectMainMenu() {
        OutputView.printMainMenus();
        MainCommand mainCommand = InputView.inputMainCommand();
        executeSelectedController(mainCommand);
    }

    private void executeSelectedController(MainCommand mainCommand) {
        if (mainCommand == QUIT) {
            runStatus = STOPPED;
            return;
        }
        ControllerHandler.executeController(mainCommand);
    }

    private enum ControllerHandler {
        STATION(MainCommand.STATION, StationController.getInstance()),
        LINE(MainCommand.LINE, LineController.getInstance()),
        PATH(MainCommand.PATH, PathController.getInstance()),
        SUBWAY_LINES(MainCommand.SUBWAY_LINES, SubWayLinesController.getInstance()),
        ;

        private static final Map<MainCommand, Controller> controllerByCommand = Arrays.stream(values())
                .collect(Collectors.toMap(value -> value.mainCommand, value -> value.controller));
        private final MainCommand mainCommand;
        private final Controller controller;

        ControllerHandler(MainCommand mainCommand, Controller controller) {
            this.mainCommand = mainCommand;
            this.controller = controller;
        }

        public static void executeController(MainCommand command) {
            Controller selectedController = controllerByCommand.get(command);
            if (selectedController == null) {
                throw new IllegalArgumentException("해당 입력 키워드로 실행할 수 있는 기능이 없습니다.");
            }
            ErrorInterceptor.runUntilGetLegalArguments(selectedController::execute);
        }
    }
}
