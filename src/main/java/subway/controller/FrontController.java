package subway.controller;

import static subway.controller.RunStatus.RUNNING;
import static subway.controller.RunStatus.STOPPED;
import static subway.view.constants.menu.MainCommand.QUIT;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.constants.menu.MainCommand;

public class FrontController extends Controller {
    private static FrontController instance;
    private RunStatus runStatus = RUNNING;

    private FrontController() {
    }

    public static FrontController getInstance() {
        if (instance == null) {
            instance = new FrontController();
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
        Controller selectedController = HandlerMapping.executeController(mainCommand);
        ErrorInterceptor.repeatUntilNoArgumentException(selectedController, Controller::execute);
    }
}
