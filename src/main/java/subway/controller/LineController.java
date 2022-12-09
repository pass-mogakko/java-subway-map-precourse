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

import java.util.List;
import subway.dto.FinalStationsDTO;
import subway.dto.LineDTO;
import subway.service.LineService;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.constants.menu.SubCommand;

public class LineController extends ManageController {
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
    void execute() {
        RunStatus runStatus = RUNNING;
        while (runStatus == RUNNING) {
            OutputView.printLineMenus();
            SubCommand command = ErrorInterceptor.repeatUntilGetLegalAnswer(InputView::inputSubCommand);
            runStatus = executeSelectedMenu(command);
        }
    }

    private RunStatus executeSelectedMenu(SubCommand command) {
        if (command == BACK) {
            return STOPPED;
        }
        ManageControllerHandler.executeFunctionByCommand(instance, command);
        return RUNNING;
    }

    @Override
    void create() {
        String lineName = InputView.inputName(LINE_CREATE_NAME_HEADER);
        String upFinalStationName = InputView.inputName(LINE_CREATE_UP_FINAL_NAME_HEADER);
        String downFinalStationName = InputView.inputName(LINE_CREATE_DOWN_FINAL_NAME_HEADER);
        lineService.addLine(new LineDTO(lineName), new FinalStationsDTO(upFinalStationName, downFinalStationName));
        OutputView.printInfoMessage(LINE_CREATE_INFO);
    }

    @Override
    void delete() {
        String lineName = InputView.inputName(LINE_DELETE_HEADER);
        lineService.deleteLine(new LineDTO(lineName));
        OutputView.printInfoMessage(LINE_DELETE_INFO);
    }

    @Override
    void read() {
        List<LineDTO> lines = lineService.getAllLines();
        OutputView.printLines(lines);
    }
}
