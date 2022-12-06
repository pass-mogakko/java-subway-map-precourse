package subway.controller;

import java.util.function.Supplier;
import subway.command.RouteCommand;
import subway.domain.RouteRepository;
import subway.view.InputView;



public class RouteController {
    public void process() {
        RouteCommand command = selectCommand();

        if (command.equals(RouteCommand.BACK)) {
            return;
        }

        if (command.equals(RouteCommand.ADD)) {
            add();
        }

        if (command.equals(RouteCommand.REMOVE)) {
            remove();
        }
    }

    private RouteCommand selectCommand() {
        while (true) {
            try {
                final String input = InputView.readRouteMenu();
                final RouteCommand command = RouteCommand.getCommand(input);

                return command;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void add() {
        final String lineName = getAddLineName();
        final String stationName = getAddStationName();
        final int location = getAddLocation();

        RouteRepository.addStation(lineName, stationName, location);
    }

    private String getAddLineName() {
        while (true) {
            try {
                final String lineName = InputView.readAddRouteLine();

                return lineName;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private String getAddStationName() {
        while (true) {
            try {
                final String stationName = InputView.readAddRouteStation();

                return stationName;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private int getAddLocation() {
        while (true) {
            try {
                final int location = InputView.readAddRouteLocation();

                return location;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void remove() {
        final String lineName = getRemoveLineName();
        final String stationName = getRemoveStationName();

        RouteRepository.removeStation(lineName, stationName);
    }


    private String getRemoveLineName() {
        while (true) {
            try {
                final String lineName = InputView.readRemoveStation();

                return lineName;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private String getRemoveStationName() {
        while (true) {
            try {
                final String stationName = InputView.readRemoveRouteStation();

                return stationName;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

}
