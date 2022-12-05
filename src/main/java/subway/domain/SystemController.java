package subway.domain;

import subway.domain.section.LineSectionController;
import subway.domain.util.ExceptionHandler;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.domain.SystemCommand.*;

public class SystemController {
    private boolean systemContinue = true;

    private final SystemService systemService = new SystemService();

    public SystemController() {
        final LineSectionController lineSectionController = new LineSectionController();
        lineSectionController.setUp();
    }

    public void run() {
        while (systemContinue) {
            OutputView.printMainPage();
            String input = ExceptionHandler.repeatForValidInput(InputView::readMainCommand);
            executeMainCommand(input);
        }
    }

    private void executeMainCommand(String input) {
        if (convertToCommand(input) == QUIT) {
            systemContinue = false;
            return;
        }
        systemService.executeCommand(input);
    }
}
