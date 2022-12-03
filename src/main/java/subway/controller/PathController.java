package subway.controller;

import static subway.controller.RunStatus.RUNNING;
import static subway.view.constants.InputMessage.PATH_CREATE_INDEX_HEADER;
import static subway.view.constants.InputMessage.PATH_CREATE_LINE_NAME_HEADER;
import static subway.view.constants.InputMessage.PATH_CREATE_STATION_NAME_HEADER;
import static subway.view.constants.SubCommand.BACK;
import static subway.view.constants.SubCommand.CREATE;
import static subway.view.constants.SubCommand.DELETE;

import java.util.List;
import subway.dto.PathDTO;
import subway.service.PathService;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.constants.SubCommand;

public class PathController {

    public static void showMenus() {
        RunStatus runStatus = RUNNING;
        while (runStatus == RUNNING) {
            OutputView.printPathDisplay();
            SubCommand command = InputView.inputSubCommand();
            runStatus = runSelectedMenu(command);
        }
    }

    public static void showAllSubwayLines() {
        List<PathDTO> allPathsByLine = PathService.getAllPathsByLine();
        OutputView.printSubwayLines(allPathsByLine);
    }

    private static RunStatus runSelectedMenu(SubCommand command) {
        if (command == BACK) {
            return RunStatus.QUIT;
        }
        if (command == CREATE) {
            String lineName = InputView.inputName(PATH_CREATE_LINE_NAME_HEADER);
            String stationName = InputView.inputName(PATH_CREATE_STATION_NAME_HEADER);
            int index = InputView.inputIndex(PATH_CREATE_INDEX_HEADER);
            // TODO insert
        }
        if (command == DELETE) {
            // TODO 메소드 실행
        }
        return RUNNING;
    }
}
