package subway.controller;

import java.util.HashMap;
import java.util.Map;
import subway.view.InputView;
import subway.view.MainScreenSelection;
import subway.view.OutputView;

public class SubwayController {

    private final StationManageController stationManageController = new StationManageController();
    private final LineManageController lineManageController = new LineManageController();
    private final Map<String, Runnable> selectionNavigator = new HashMap<>();

    public SubwayController() {
        selectionNavigator.put(MainScreenSelection.ONE.getSelection(), stationManageController::run);
        selectionNavigator.put(MainScreenSelection.TWO.getSelection(), lineManageController::run);
    }

    public void run() {
        try {
            String mainScreenSelection = InputView.requestMainScreenSelection();
            selectionNavigator.get(mainScreenSelection)
                    .run();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
        run();
    }
}
