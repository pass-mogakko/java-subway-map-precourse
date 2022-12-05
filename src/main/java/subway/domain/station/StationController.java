package subway.domain.station;

import subway.domain.util.ExceptionHandler;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.domain.station.StationCommand.*;

public class StationController {
    private static final StationController stationController = new StationController();
    private static final StationService stationService = new StationService();

    public void run() {
        OutputView.printStationPage();
        String input = ExceptionHandler.repeatForValidInput(stationController::readCommand);
        StationCommand command = getCode(input);
        executeCommand(command);
    }

    private void executeCommand(StationCommand command) {
        if (command == ADD_STATION) addStation();
//        if (command == StationCommand.DELETE_STATION) deleteStation();
//        if (command == StationCommand.SHOW_STATION) showStation();
//        if (command == StationCommand.BACK) return;
    }

    private void addStation() {
        String stationName = InputView.readStationName();
    }

    private String readCommand() {
        String input = InputView.readMainCommand();
        stationService.validateCommand(input);
        return input;
    }
}
