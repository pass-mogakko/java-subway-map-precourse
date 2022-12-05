package subway.domain;

import subway.domain.section.LineSectionController;
import subway.domain.util.ExceptionHandler;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.domain.SystemCommand.*;

public class SystemController {
    private static final SystemController systemController = new SystemController();
    private static final SystemService systemService = new SystemService();

    public SystemController() {
        final LineSectionController lineSectionController = new LineSectionController();
        lineSectionController.setUp();
    }

    public void run() {
        OutputView.printMainPage();
        String input = ExceptionHandler.repeatForValidInput(systemController::readMainCommand);
        SystemCommand command = convertToCommand(input);
        systemService.executeCommand(command);
    }

    private String readMainCommand() {
        String input = InputView.readMainCommand();
        systemService.validateCommand(input);
        return input;
    }
}
