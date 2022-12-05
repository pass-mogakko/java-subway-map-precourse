package subway.controller;

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
import static subway.view.constants.menu.SubCommand.CREATE;
import static subway.view.constants.menu.SubCommand.DELETE;

import java.util.List;
import subway.dto.PathDTO;
import subway.service.PathService;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.constants.menu.SubCommand;

public class PathController {

    private static final PathService pathService = PathService.getInstance();

    private PathController() {
    }

    static void selectMenu() {
        RunStatus runStatus = RUNNING;
        while (runStatus == RUNNING) {
            OutputView.printPathMenus();
            SubCommand command = InputView.inputSubCommand();
            runStatus = runSelectedMenu(command);
        }
    }

    static void showAllSubwayLines() {
        List<PathDTO> allPathsByLine = pathService.getAllPathsByLine();
        OutputView.printSubwayLines(allPathsByLine);
    }

    private static RunStatus runSelectedMenu(SubCommand command) {
        if (command == BACK) {
            return STOPPED;
        }
        if (command == CREATE) {
            insertStationToPath();
        }
        if (command == DELETE) {
            deleteStationFromPath();
        }
        return RUNNING;
    }

    private static void insertStationToPath() {
        String lineName = InputView.inputName(PATH_CREATE_LINE_NAME_HEADER);
        String stationName = InputView.inputName(PATH_CREATE_STATION_NAME_HEADER);
        int index = InputView.inputIndex(PATH_CREATE_INDEX_HEADER);
        pathService.insertStationToPath(lineName, stationName, index);
        OutputView.printInfoMessage(PATH_CREATE_INFO);
    }

    private static void deleteStationFromPath() {
        String lineName = InputView.inputName(PATH_DELETE_LINE_NAME_HEADER);
        String stationName = InputView.inputName(PATH_DELETE_STATION_NAME_HEADER);
        pathService.deleteStationFromPath(lineName, stationName);
        OutputView.printInfoMessage(PATH_DELETE_INFO);
    }
}
