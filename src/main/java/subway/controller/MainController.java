package subway.controller;


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
    final private StationController stationController = new StationController();
    final private LineController lineController = new LineController();
    final private RouteController routeController = new RouteController();

    public void run() {
        while (true) {
            final MainCommand command = selectCommand();

            if (command.equals(MainCommand.QUIT)) {
                return;
            }

            if (command.equals(MainCommand.STATION)) {
                processStation();
            }

            if (command.equals(MainCommand.LINE)) {
                processLine();
            }

            if (command.equals(MainCommand.ROUTE)) {
                processRoute();
            }

            if (command.equals(MainCommand.SHOW)) {
                processShow();
            }
        }
    }

    private MainCommand selectCommand() {
        while (true) {
            try {
                final String input = InputView.readMainMenu();
                final MainCommand command = MainCommand.getCommand(input);

                return command;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void processStation() {
        stationController.process();
    }

    private void processLine() {
        lineController.process();
    }

    private void processRoute() {
        routeController.process();
    }

    private void processShow() {
        for (Route route : RouteRepository.routes()) {
            OutputView.printRoute(route.getLineName(), route.getStationNames());
        }
    }
}
