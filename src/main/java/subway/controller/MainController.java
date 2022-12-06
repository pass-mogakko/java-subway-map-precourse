package subway.controller;

import subway.constants.Mode;
import subway.domain.command.MainCommand;
import subway.view.input.MainInputView;

public class MainController {

    public void run() {
        while (true) {
            MainCommand enteredCommand = readCommand();
            if (enteredCommand == null) {
                continue;
            }
            if (enteredCommand.equals(MainCommand.QUIT)) {
                break;
            }

            executeManage(enteredCommand);
        }
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
            return null;
        }
    }
}
