package subway.controller;

import subway.command.StationCommand;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class StationController implements Controllable {
    private Map<StationCommand, Runnable> stationRunnables;

    public StationController() {
        stationRunnables = new HashMap<>();

        stationRunnables.put(StationCommand.ADD, this::add);
        stationRunnables.put(StationCommand.REMOVE, this::remove);
        stationRunnables.put(StationCommand.SHOW, this::show);
    }

    @Override
    public void process() {
        StationCommand command = Repeater.repeatInput(this::selectCommand);

        while (!command.equals(StationCommand.BACK)) {
            Runnable runnable = stationRunnables.get(command);
            Repeater.repeatRun(runnable);

            command = Repeater.repeatInput(this::selectCommand);
        }
    }

    private StationCommand selectCommand() {
        final String input = Repeater.repeatInput(InputView::readStationMenu);

        return StationCommand.getCommand(input);
    }

    private void add() {
        final String stationName = Repeater.repeatInput(InputView::readAddStation);
        StationRepository.addStation(stationName);

        OutputView.printStationAddSuccess();
    }

    private void remove() {
        final String input = Repeater.repeatInput(InputView::readRemoveStation);
        StationRepository.deleteStation(input);

        OutputView.printStationRemoveSuccess();
    }

    private void show() {
        List<Station> stations = StationRepository.stations();
        List<String> stationNames = stations.stream()
                .map(Station::getName)
                .collect(Collectors.toList());

        OutputView.printStations(stationNames);
    }
}
