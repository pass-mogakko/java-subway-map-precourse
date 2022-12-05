package subway.domain.station;

import subway.domain.util.ExceptionHandler;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.domain.station.StationCommand.*;

public class StationController {
    private static final StationService stationService = new StationService();

    public void run() {
        OutputView.printStationPage();
        String input = ExceptionHandler.repeatForValidInput(InputView::readDetailCommand);
        executeCommand(input);
    }

    private void executeCommand(String input) {
        stationService.validateCommand(input);
        StationCommand command = getCode(input);

        if (command == ADD_STATION) addStation();
//        if (command == StationCommand.DELETE_STATION) deleteStation();
//        if (command == StationCommand.SHOW_STATION) showStation();
//        if (command == StationCommand.BACK) return;
    }

    private void addStation() {
        String stationName = ExceptionHandler.repeatForValidInput(InputView::readStationName);
        stationService.addStation(stationName);
    }
}
