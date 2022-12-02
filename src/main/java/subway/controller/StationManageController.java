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
        String stationManageSelection = InputView.requestStationManageSelection();
        selectionNavigator.get(stationManageSelection)
                .run();
    }


    private void registerStation() {
        String registerStation = InputView.requestRegisterStation();
        stationManageService.registerStation(registerStation);
    }

    private void deleteStation() {
        String deleteStation = InputView.requestDeleteStation();
        stationManageService.deleteStation(deleteStation);
    }

    private void lookupStation() {
        List<String> allStation = stationManageService.lookupStation();
        OutputView.printAllStation(allStation);
    }

}
