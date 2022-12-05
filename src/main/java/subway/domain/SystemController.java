package subway.domain;

import subway.domain.line.LineController;
import subway.domain.section.LineSectionController;
import subway.domain.station.StationController;
import subway.domain.util.ExceptionHandler;
import subway.view.InputView;
import subway.view.OutputView;

public class SystemController {

    private SystemController() {
        LineSectionController.setUp();
    }

    public static void run() {
        OutputView.printMain();
        String input = ExceptionHandler.repeatForValidInput(SystemController::readMainCommand);
        SystemService.executeCommand(input);
    }

    private static String readMainCommand() {
        String input = ExceptionHandler.repeatForValidInput(InputView::readMainCommand);
        SystemService.executeCommand(input);
        return input;
    }

}
