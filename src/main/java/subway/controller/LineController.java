package subway.controller;

import static subway.controller.RunStatus.RUNNING;
import static subway.controller.RunStatus.STOPPED;
import static subway.view.constants.InputMessage.LINE_CREATE_DOWN_FINAL_NAME_HEADER;
import static subway.view.constants.InputMessage.LINE_CREATE_NAME_HEADER;
import static subway.view.constants.InputMessage.LINE_CREATE_UP_FINAL_NAME_HEADER;
import static subway.view.constants.InputMessage.LINE_DELETE_HEADER;
import static subway.view.constants.OutputMessage.LINE_CREATE_INFO;
import static subway.view.constants.OutputMessage.LINE_DELETE_INFO;
import static subway.view.constants.menu.SubCommand.BACK;
import static subway.view.constants.menu.SubCommand.CREATE;
import static subway.view.constants.menu.SubCommand.DELETE;
import static subway.view.constants.menu.SubCommand.READ;

import java.util.List;
import subway.dto.FinalStationsDTO;
import subway.dto.LineDTO;
import subway.service.LineService;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.constants.menu.SubCommand;

public class LineController implements Controller {
    private static LineController instance;
    private final LineService lineService = LineService.getInstance();

    private LineController() {
    }

    public static LineController getInstance() {
        if (instance == null) {
            instance = new LineController();
        }
        return instance;
    }

    @Override
    public void execute() {
        RunStatus runStatus = RUNNING;
        while (runStatus == RUNNING) {
            OutputView.printLineMenus();
            SubCommand command = InputView.inputSubCommand();
            runStatus = runSelectedMenu(command);
        }
    }

    private RunStatus runSelectedMenu(SubCommand command) {
        if (command == BACK) {
            return STOPPED;
        }
        if (command == CREATE) {
            createLine();
        }
        if (command == DELETE) {
            deleteLine();
        }
        if (command == READ) {
            readLines();
        }
        return RUNNING;
    }

    private void createLine() {
        String lineName = InputView.inputName(LINE_CREATE_NAME_HEADER);
        String upFinalStationName = InputView.inputName(LINE_CREATE_UP_FINAL_NAME_HEADER);
        String downFinalStationName = InputView.inputName(LINE_CREATE_DOWN_FINAL_NAME_HEADER);
        lineService.addLine(new LineDTO(lineName), new FinalStationsDTO(upFinalStationName, downFinalStationName));
        OutputView.printInfoMessage(LINE_CREATE_INFO);
    }

    private void deleteLine() {
        String lineName = InputView.inputName(LINE_DELETE_HEADER);
        lineService.deleteLine(new LineDTO(lineName));
        OutputView.printInfoMessage(LINE_DELETE_INFO);
    }

    private void readLines() {
        List<LineDTO> lines = lineService.getAllLines();
        OutputView.printLines(lines);
    }
}
