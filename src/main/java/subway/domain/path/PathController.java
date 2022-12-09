package subway.domain.path;

import static subway.controller.RunStatus.RUNNING;
import static subway.controller.RunStatus.STOPPED;
import static subway.view.constants.InputMessage.PATH_CREATE_INDEX_HEADER;
import static subway.view.constants.InputMessage.PATH_CREATE_LINE_NAME_HEADER;
import static subway.view.constants.InputMessage.PATH_CREATE_STATION_NAME_HEADER;
import static subway.view.constants.InputMessage.PATH_DELETE_LINE_NAME_HEADER;
import static subway.view.constants.InputMessage.PATH_DELETE_STATION_NAME_HEADER;
import static subway.view.constants.OutputMessage.PATH_CREATE_INFO;
import static subway.view.constants.OutputMessage.PATH_DELETE_INFO;
import static subway.view.constants.menu.SubCommand.BACK;

import subway.controller.ErrorInterceptor;
import subway.controller.HandlerAdaptor;
import subway.controller.ManageController;
import subway.controller.RunStatus;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.constants.menu.SubCommand;

public class PathController extends ManageController {
    private static PathController instance;
    private final PathService pathService = PathService.getInstance();

    private PathController() {
    }

    public static PathController getInstance() {
        if (instance == null) {
            instance = new PathController();
        }
        return instance;
    }

    @Override
    protected void execute() {
        RunStatus runStatus = RUNNING;
        while (runStatus == RUNNING) {
            OutputView.printPathMenus();
            SubCommand command = ErrorInterceptor.repeatUntilGetLegalAnswer(InputView::inputSubCommand);
            runStatus = runSelectedMenu(command);
        }
    }

    private RunStatus runSelectedMenu(SubCommand command) {
        if (command == BACK) {
            return STOPPED;
        }
        HandlerAdaptor.executeFunctionByCommand(instance, command);
        return RUNNING;
    }

    @Override
    protected void create() {
        String lineName = InputView.inputName(PATH_CREATE_LINE_NAME_HEADER);
        String stationName = InputView.inputName(PATH_CREATE_STATION_NAME_HEADER);
        int index = InputView.inputIndex(PATH_CREATE_INDEX_HEADER);
        pathService.insertStationToPath(lineName, stationName, index);
        OutputView.printInfoMessage(PATH_CREATE_INFO);
    }

    @Override
    protected void delete() {
        String lineName = InputView.inputName(PATH_DELETE_LINE_NAME_HEADER);
        String stationName = InputView.inputName(PATH_DELETE_STATION_NAME_HEADER);
        pathService.deleteStationFromPath(lineName, stationName);
        OutputView.printInfoMessage(PATH_DELETE_INFO);
    }

    @Override
    protected void read() {
        throw new IllegalArgumentException("제공하지 않는 기능을 요청했습니다.");
    }
}
