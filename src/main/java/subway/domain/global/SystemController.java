package subway.domain.global;

import subway.domain.util.ExceptionHandler;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.domain.global.SystemCommand.QUIT;
import static subway.domain.global.SystemCommand.convertToCommand;

public class SystemController {
    private boolean systemContinue = true;

    private final SystemService systemService = new SystemService();

    public SystemController() {
        systemService.setUp();
    }

    public void run() {
        while (systemContinue) {
            try {
                OutputView.printMainPage();
                String input = ExceptionHandler.repeatForValidInput(InputView::readMainCommand);
                executeMainCommand(input);
            } catch (IllegalArgumentException e) {
                OutputView.print(e.getMessage());
            }
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
