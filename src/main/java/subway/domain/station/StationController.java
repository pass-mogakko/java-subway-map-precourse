package subway.domain.station;

import subway.domain.util.ExceptionHandler;
import subway.domain.util.MessageFactory;
import subway.view.InputView;
import subway.view.OutputView;
import static subway.domain.station.StationCommand.*;
import static subway.domain.util.InfoCode.*;

public class StationController {
    private static final StationService stationService = new StationService();
    private final MessageFactory messageFactory = new MessageFactory();

    public void setUp() {
        stationService.setUp();
    }

    public void run() {
        OutputView.printStationPage();
        String input = ExceptionHandler.repeatForValidInput(InputView::readDetailCommand);
        executeCommand(input);
    }

    private void executeCommand(String input) {
        StationCommand command = getCode(input);

        if (command == ADD_STATION) addStation();
        if (command == StationCommand.DELETE_STATION) deleteStation();
        if (command == StationCommand.SHOW_STATION) showAllStations();
        if (command == StationCommand.BACK) return;
    }

    private void addStation() {
        String stationName = ExceptionHandler.repeatForValidInput(InputView::readStationNameToAdd);
        stationService.addStation(stationName);
        OutputView.print(messageFactory.makeInfoMessage(STATION_ADDITION_COMPLETE));
    }

    private void deleteStation() {
        String stationName = ExceptionHandler.repeatForValidInput(InputView::readStationNameToDelete);
        stationService.deleteStation(stationName);
        OutputView.print(messageFactory.makeInfoMessage(STATION_DELETION_COMPLETE));
    }

    private void showAllStations() {
        String result = stationService.showAllStations();
        OutputView.print(result);
    }

}
