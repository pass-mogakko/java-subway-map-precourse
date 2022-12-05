package subway.domain;

import subway.domain.section.LineSectionController;
import subway.domain.util.ExceptionHandler;
import subway.view.InputView;
import subway.view.OutputView;

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
        systemService.executeCommand(input);
    }

    private String readMainCommand() {
        String input = InputView.readMainCommand();
        systemService.validateCommand(input);
        return input;
    }
}
