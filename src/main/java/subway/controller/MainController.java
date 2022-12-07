package subway.controller;


import subway.command.MainCommand;
import subway.view.InputView;

import java.util.HashMap;
import java.util.Map;


public class MainController {
    private MainCommand selectCommand() {
        final String input = Repeater.repeatInput(InputView::readMainMenu);

        return MainCommand.getCommand(input);
    }

    public void run() {
        MainCommand command = Repeater.repeatInput(this::selectCommand);

        while (!command.equals(MainCommand.QUIT)) {
            Controllable controllable = ManageController.getController(command);
            controllable.process();

            command = Repeater.repeatInput(this::selectCommand);
        }
    }
}
