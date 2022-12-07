package subway.controller;

import java.util.List;
import java.util.stream.Collectors;
import subway.command.StationCommand;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;



public class StationController implements Controllable {
    @Override
    public void process() {
        final StationCommand command = selectCommand();

        if (command.equals(StationCommand.BACK)) {
            return;
        }

        if (command.equals(StationCommand.ADD)) {
            add();
        }

        if (command.equals(StationCommand.REMOVE)) {
            remove();
        }

        if (command.equals(StationCommand.SHOW)) {
            show();
        }
    }

    private StationCommand selectCommand() {
        while (true) {
            try {
                final String input = InputView.readStationMenu();

                return StationCommand.getCommand(input);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void add() {
        while (true) {
            try {
                final String stationName = InputView.readAddStation();

                StationRepository.addStation(stationName);

                OutputView.printStationAddSuccess();

                return;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void remove() {
        while (true) {
            try {
                final String input = InputView.readRemoveStation();

                StationRepository.deleteStation(input);

                OutputView.printStationRemoveSuccess();

                return;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void show() {
        List<Station> stations = StationRepository.stations();
        List<String> stationNames = stations.stream()
                .map(Station::getName)
                .collect(Collectors.toList());

        OutputView.printStations(stationNames);
    }
}
