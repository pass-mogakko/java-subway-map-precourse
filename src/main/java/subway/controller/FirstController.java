package subway.controller;

import static subway.controller.RunStatus.RUNNING;
import static subway.controller.RunStatus.STOPPED;
import static subway.view.constants.menu.MainCommand.QUIT;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.constants.menu.MainCommand;

public class FirstController {

    private static RunStatus runStatus = STOPPED;

    private FirstController() {
    }

    public static void run() {
        runStatus = RUNNING;
        while (runStatus == RUNNING) {
            ErrorInterceptor.runUntilGetLegalArguments(FirstController::selectMainMenu);
        }
    }

    private static void selectMainMenu() {
        OutputView.printMainMenus();
        MainCommand mainCommand = InputView.inputMainCommand();
        runSelectedController(mainCommand);
    }

    private static void runSelectedController(MainCommand mainCommand) {
        if (mainCommand == QUIT) {
            runStatus = STOPPED;
            return;
        }
        ControllerHandler.run(mainCommand);
    }
}
