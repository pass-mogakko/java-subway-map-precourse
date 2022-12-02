package subway.controller;

import java.util.HashMap;
import java.util.Map;
import subway.view.InputView;
import subway.view.MainScreenSelection;
import subway.view.OutputView;

public class SubwayController {

    private final Map<String, Runnable> selectionNavigator = new HashMap<>();
    private final StationManageController stationManageController = new StationManageController();
    private final LineManageController lineManageController = new LineManageController();
    private final SectionManageController sectionManageController = new SectionManageController();

    public SubwayController() {
        selectionNavigator.put(MainScreenSelection.ONE.getSelection(), stationManageController::run);
        selectionNavigator.put(MainScreenSelection.TWO.getSelection(), lineManageController::run);
        selectionNavigator.put(MainScreenSelection.THREE.getSelection(), sectionManageController::run);
    }

    public void run() {
        try {
            String mainScreenSelection = InputView.requestMainScreenSelection();
            Runnable nextAction = selectionNavigator.get(mainScreenSelection);
            nextAction.run();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
        run();
    }
}
