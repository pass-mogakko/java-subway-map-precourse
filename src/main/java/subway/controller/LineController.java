package subway.controller;

import static subway.controller.RunStatus.RUNNING;
import static subway.view.constants.SubCommand.BACK;
import static subway.view.constants.SubCommand.CREATE;
import static subway.view.constants.SubCommand.DELETE;
import static subway.view.constants.SubCommand.READ;

import java.util.List;
import subway.dto.LineDTO;
import subway.service.LineService;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.constants.SubCommand;

public class LineController {

    public void run() {
        RunStatus runStatus = RUNNING;
        while (runStatus == RUNNING) {
            OutputView.printLineDisplay();
            SubCommand command = InputView.inputSubCommand();
            runStatus = runSelectedFunction(command);
        }
    }

    private RunStatus runSelectedFunction(SubCommand command) {
        if (command == BACK) {
            return RunStatus.QUIT;
        }
        if (command == CREATE) {
            // TODO 메소드 실행
        }
        if (command == DELETE) {
            // TODO 메소드 실행
        }
        if (command == READ) {
            List<LineDTO> lines = LineService.getAllLines();
            OutputView.printLines(lines);
        }
        return RUNNING;
    }
}
