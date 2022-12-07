package subway.controller;


import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import subway.command.MainCommand;
import subway.domain.Route;
import subway.domain.RouteRepository;
import subway.view.InputView;
import subway.view.OutputView;



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
        final MainCommand command = MainCommand.getCommand(input);

        return command;
    }

    public void run() {
        MainCommand command = Repeater.repeatFindByInput(this::selectCommand);

        while (!command.equals(MainCommand.QUIT)){
            Controllable controllable = mainControllers.get(command);
            controllable.process();

            command = Repeater.repeatFindByInput(this::selectCommand);
        }
    }
}
