package subway.controller;

import subway.constants.Mode;
import subway.constants.menu.Menu;
import subway.domain.command.MainCommand;
import subway.view.input.MainInputView;
import subway.view.output.MainOutputView;

public class MainController {

    public void run() {
        MainOutputView.printMenu(Menu.MAIN);
        MainCommand enteredCommand = readCommand();
        if (enteredCommand.equals(MainCommand.QUIT)) {
            return;
        }
        executeManage(enteredCommand);
        run();
    }

    public void executeManage(MainCommand mainCommand) {
        ManagementController managementController = Mode.findControllerByMainCommand(mainCommand);
        managementController.execute();
    }

    public MainCommand readCommand() {
        try {
            MainCommand mainCommand = MainInputView.readMainMenu();
            return mainCommand;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readCommand();
        }
    }
}
