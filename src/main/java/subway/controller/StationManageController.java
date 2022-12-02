package subway.controller;

import subway.service.StationManageService;
import subway.view.InputView;
import subway.view.StationManageSelection;

public class StationManageController {

    private final StationManageService stationManageService = new StationManageService();

    public void run() {
        String stationManageSelection = InputView.requestStationManageSelection();

        if (stationManageSelection.equals(StationManageSelection.ONE.getSelection())) {
            registerStation();
        }
        if (stationManageSelection.equals(StationManageSelection.TWO.getSelection())) {
            deleteStation();
        }
    }


    private void registerStation() {
        String registerStation = InputView.requestRegisterStation();
        stationManageService.registerStation(registerStation);
    }

    private void deleteStation() {
        String deleteStation = InputView.requestDeleteStation();
        stationManageService.deleteStation(deleteStation);
    }

}
