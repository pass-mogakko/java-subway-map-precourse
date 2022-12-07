package subway.controller;


import subway.command.MainCommand;
import subway.view.InputView;

import java.util.HashMap;
import java.util.Map;


public class MainController {
    private final Map<MainCommand, Controllable> mainControllers;

    public MainController() {
        mainControllers = new HashMap<>();

        mainControllers.put(MainCommand.STATION, new StationController());
        mainControllers.put(MainCommand.LINE, new LineController());
        mainControllers.put(MainCommand.ROUTE, new RouteController());
        mainControllers.put(MainCommand.SHOW, new ShowController());
    }

    private MainCommand selectCommand() {
        final String input = Repeater.repeatInput(InputView::readMainMenu);

        return MainCommand.getCommand(input);
    }

    public void run() {
        MainCommand command = Repeater.repeatInput(this::selectCommand);

        while (!command.equals(MainCommand.QUIT)) {
            Controllable controllable = mainControllers.get(command);
            controllable.process();

            command = Repeater.repeatInput(this::selectCommand);
        }
    }
}
