package subway.domain.line;

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
import subway.controller.ErrorInterceptor;
import subway.controller.HandlerAdaptor;
import subway.controller.ManageController;
import subway.controller.RunStatus;
import subway.domain.path.PathService;
import subway.dto.FinalStationsDTO;
import subway.dto.LineDTO;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.constants.menu.SubCommand;

public class LineController extends ManageController {
    private static LineController instance;
    private final LineService lineService = LineService.getInstance();
    private final PathService pathService = PathService.getInstance();

    private LineController() {
    }

    public static LineController getInstance() {
        if (instance == null) {
            instance = new LineController();
        }
        return instance;
    }

    @Override
    protected void execute() {
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
        HandlerAdaptor.executeFunctionByCommand(instance, command);
        return RUNNING;
    }

    @Override
    protected void create() {
        String lineName = InputView.inputName(LINE_CREATE_NAME_HEADER);
        String upFinalStationName = InputView.inputName(LINE_CREATE_UP_FINAL_NAME_HEADER);
        String downFinalStationName = InputView.inputName(LINE_CREATE_DOWN_FINAL_NAME_HEADER);
        lineService.addLine(new LineDTO(lineName));
        pathService.addPath(new LineDTO(lineName), new FinalStationsDTO(upFinalStationName, downFinalStationName));
        OutputView.printInfoMessage(LINE_CREATE_INFO);
    }

    @Override
    protected void delete() {
        String lineName = InputView.inputName(LINE_DELETE_HEADER);
        pathService.deletePath(lineName);
        lineService.deleteLine(new LineDTO(lineName));
        OutputView.printInfoMessage(LINE_DELETE_INFO);
    }

    @Override
    protected void read() {
        List<LineDTO> lines = lineService.getAllLines();
        OutputView.printLines(lines);
    }
}
