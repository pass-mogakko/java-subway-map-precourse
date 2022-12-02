package subway.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import subway.service.StationManageService;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.StationManageSelection;

public class StationManageController {

    private final StationManageService stationManageService = new StationManageService();
    private final Map<String, Runnable> selectionNavigator = new HashMap<>();

    public StationManageController() {
        selectionNavigator.put(StationManageSelection.ONE.getSelection(), this::registerStation);
        selectionNavigator.put(StationManageSelection.TWO.getSelection(), this::deleteStation);
        selectionNavigator.put(StationManageSelection.THREE.getSelection(), this::lookupStation);
    }

    public void run() {
        try {
            String stationManageSelection = InputView.requestStationManageSelection();
            if (stationManageSelection.equals(StationManageSelection.BACK.getSelection())) {
                return;
            }
            Runnable nextAction = selectionNavigator.get(stationManageSelection);
            nextAction.run();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            run();
        }
    }

    private void registerStation() {
        try {
            String registerStation = InputView.requestRegisterStation();
            stationManageService.validateIsUnregisterStation(registerStation);
            stationManageService.registerStation(registerStation);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            registerStation();
        }
        OutputView.printRegisterStation();
    }

    private void deleteStation() {
        try {
            String deleteStation = InputView.requestDeleteStation();
            stationManageService.deleteStation(deleteStation);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            deleteStation();
        }
        OutputView.printDeleteStation();
    }

    private void lookupStation() {
        List<String> allStations = stationManageService.lookupStation();
        OutputView.printAllStations(allStations);
    }
}
