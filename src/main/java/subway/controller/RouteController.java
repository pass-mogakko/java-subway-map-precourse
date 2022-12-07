package subway.controller;

import subway.command.RouteCommand;
import subway.domain.RouteRepository;
import subway.view.InputView;

import java.util.HashMap;
import java.util.Map;


public class RouteController implements Controllable {
    private final Map<RouteCommand, Runnable> routeRunnables;

    public RouteController() {
        routeRunnables = new HashMap<>();

        routeRunnables.put(RouteCommand.ADD, this::add);
        routeRunnables.put(RouteCommand.REMOVE, this::remove);
    }

    @Override
    public void process() {
        RouteCommand command = Repeater.repeatInput(this::selectCommand);

        while (!command.equals(RouteCommand.BACK)) {
            Runnable runnable = routeRunnables.get(command);
            Repeater.repeatRun(runnable);

            command = Repeater.repeatInput(this::selectCommand);
        }
    }

    private RouteCommand selectCommand() {
        final String input = Repeater.repeatInput(InputView::readRouteMenu);

        return RouteCommand.getCommand(input);
    }

    private void add() {
        final String lineName = Repeater.repeatInput(InputView::readAddRouteLine);
        final String stationName = Repeater.repeatInput(InputView::readAddRouteStation);
        final int location = Repeater.repeatInput(InputView::readAddRouteLocation);

        RouteRepository.addStation(lineName, stationName, location);
    }

    private void remove() {
        final String lineName = Repeater.repeatInput(InputView::readRemoveRouteLine);
        final String stationName = Repeater.repeatInput(InputView::readRemoveRouteStation);

        RouteRepository.removeStation(lineName, stationName);
    }
}
