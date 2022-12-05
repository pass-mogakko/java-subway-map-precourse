package subway.domain.station;

import subway.domain.util.ExceptionHandler;
import subway.domain.util.InfoCode;
import subway.domain.util.MessageFactory;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.domain.station.StationCommand.*;
import static subway.domain.util.InfoCode.ADD_STATION_COMPLETE;

public class StationController {
    private static final StationService stationService = new StationService();
    private final MessageFactory messageFactory = new MessageFactory();

    public void run() {
        OutputView.printStationPage();
        String input = ExceptionHandler.repeatForValidInput(InputView::readDetailCommand);
        executeCommand(input);
    }

    private void executeCommand(String input) {
        StationCommand command = getCode(input);

        if (command == ADD_STATION) addStation();
//        if (command == StationCommand.DELETE_STATION) deleteStation();
//        if (command == StationCommand.SHOW_STATION) showStation();
//        if (command == StationCommand.BACK) return;
    }

    private void addStation() {
        String stationName = ExceptionHandler.repeatForValidInput(InputView::readStationName);
        stationService.addStation(stationName);
        OutputView.print(messageFactory.makeInfoMessage(ADD_STATION_COMPLETE));
    }
}
