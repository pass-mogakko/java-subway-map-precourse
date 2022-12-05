package subway.domain.global;

import subway.domain.line.LineController;
import subway.domain.section.LineSectionController;
import subway.domain.station.StationController;
import subway.domain.util.ExceptionHandler;
import subway.view.InputView;
import subway.view.OutputView;
import static subway.domain.global.SystemCommand.*;

public class SystemController {
    private boolean systemContinue = true;

    private final SystemService systemService = new SystemService();
    private final StationController stationController = new StationController();
    private final LineController lineController = new LineController();
    private final LineSectionController lineSectionController = new LineSectionController();

    public SystemController() {
        stationController.setUp();
        lineController.setUp();
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
