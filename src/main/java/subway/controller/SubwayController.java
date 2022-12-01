package subway.controller;

import subway.view.InputView;
import subway.view.MainScreenSelection;

public class SubwayController {

    private final StationManageController stationManageController = new StationManageController();


    public void run() {
        String mainScreenSelection = InputView.requestMainScreenSelection();

        if (mainScreenSelection.equals(MainScreenSelection.ONE.getSelection())) {
            stationManageController.run();
        }
    }
}
