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

public class SubwayController {

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
            // TODO StationController 실행
        }
        if (mainCommand == LINE) {
            // TODO LineController 실행
        }
        if (mainCommand == PATH) {
            // TODO PathController 실행
        }
        if (mainCommand == SUBWAY_LINES) {
            // TODO PathController 실행
        }
        return RUNNING;
    }
}
