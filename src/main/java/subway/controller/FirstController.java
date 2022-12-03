package subway.controller;

import static subway.controller.RunStatus.RUNNING;
import static subway.view.constants.MainCommand.LINE;
import static subway.view.constants.MainCommand.PATH;
import static subway.view.constants.MainCommand.QUIT;
import static subway.view.constants.MainCommand.STATION;
import static subway.view.constants.MainCommand.SUBWAY_LINES;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.constants.MainCommand;

public class FirstController {
    
    public void run() {
        RunStatus runStatus = RUNNING;
        while (runStatus == RUNNING) {
            OutputView.printMain();
            MainCommand mainCommand = InputView.inputMainCommand();
            runStatus = runSelectedController(mainCommand);
        }
    }

    private RunStatus runSelectedController(MainCommand mainCommand) {
        if (mainCommand == QUIT) {
            return RunStatus.QUIT;
        }
        if (mainCommand == STATION) {
            StationController.showMenus();
        }
        if (mainCommand == LINE) {
            LineController.showMenus();
        }
        if (mainCommand == PATH) {
            PathController.showMenus();
        }
        if (mainCommand == SUBWAY_LINES) {
            PathController.showAllSubwayLines();
        }
        return RUNNING;
    }
}
