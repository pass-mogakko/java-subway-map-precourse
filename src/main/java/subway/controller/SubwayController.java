package subway.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import subway.dto.SectionDto;
import subway.service.SectionManageService;
import subway.view.InputView;
import subway.view.MainScreenSelection;
import subway.view.OutputView;

public class SubwayController {

    private final Map<String, Runnable> selectionNavigator = new HashMap<>();
    private final SectionManageService sectionManageService = new SectionManageService();

    public SubwayController() {
        StationManageController stationManageController = new StationManageController();
        LineManageController lineManageController = new LineManageController();
        SectionManageController sectionManageController = new SectionManageController();
        selectionNavigator.put(MainScreenSelection.ONE.getSelection(), stationManageController::run);
        selectionNavigator.put(MainScreenSelection.TWO.getSelection(), lineManageController::run);
        selectionNavigator.put(MainScreenSelection.THREE.getSelection(), sectionManageController::run);
        selectionNavigator.put(MainScreenSelection.FOUR.getSelection(), this::printSubwayMap);
    }

    public void run() {
        try {
            String mainScreenSelection = InputView.requestMainScreenSelection();
            if (mainScreenSelection.equals(MainScreenSelection.QUIT.getSelection())) {
                return;
            }
            Runnable nextAction = selectionNavigator.get(mainScreenSelection);
            nextAction.run();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
        run();
    }

    private void printSubwayMap() {
        List<SectionDto> subwayMap = sectionManageService.findAllSectionDtos();
        OutputView.printSubwayMap(subwayMap);
    }
}
