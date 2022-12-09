package subway.controller;

import static subway.controller.RunStatus.RUNNING;
import static subway.controller.RunStatus.STOPPED;
import static subway.view.constants.menu.MainCommand.QUIT;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.constants.menu.MainCommand;

public class FirstController extends Controller {
    private static FirstController instance;
    private RunStatus runStatus = RUNNING;

    private FirstController() {
    }

    public static FirstController getInstance() {
        if (instance == null) {
            instance = new FirstController();
        }
        return instance;
    }

    @Override
    public void execute() {
        try {
            if (runStatus == STOPPED) {
                return;
            }
            OutputView.printMainMenus();
            MainCommand mainCommand = ErrorInterceptor.repeatUntilGetLegalAnswer(InputView::inputMainCommand);
            executeSelectedController(mainCommand);
            execute();
        } catch (Exception exception) {
            OutputView.printErrorMessage(exception.getMessage());
        }
    }
    
    private void executeSelectedController(MainCommand mainCommand) {
        if (mainCommand == QUIT) {
            runStatus = STOPPED;
            return;
        }
        FirstControllerHandler.executeController(mainCommand);
    }
}
