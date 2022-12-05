package subway.domain.global;

import subway.domain.line.LineController;
import subway.domain.section.LineSectionController;
import subway.domain.station.StationController;
import subway.domain.util.ExceptionHandler;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.domain.global.SystemCommand.*;
import static subway.domain.global.SystemCommand.SHOW_LINE_SECTION_MAP;

public class SystemController {
    private boolean systemContinue = true;

    private static final StationController stationController = new StationController();
    private static final LineController lineController = new LineController();
    private static final LineSectionController lineSectionController = new LineSectionController();

    public SystemController() {
        stationController.setUp();
        lineController.setUp();
        lineSectionController.setUp();
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
        SystemCommand command = convertToCommand(input);

        if (command == STATION_MANAGEMENT) stationController.run();
        if (command == LINE_MANAGEMENT) lineController.run();
        if (command == SECTION_MANAGEMENT) lineSectionController.run();
        if (command == SHOW_LINE_SECTION_MAP) lineSectionController.showMap();
        if (command == QUIT) systemContinue = false;
    }

}
