package subway.controller;

import java.util.HashMap;
import java.util.Map;
import subway.service.SectionManageService;
import subway.utils.Utils;
import subway.view.InputView;
import subway.view.LineManageSelection;
import subway.view.OutputView;
import subway.view.SectionManageSelection;

public class SectionManageController {

    private final Map<String, Runnable> selectionNavigator = new HashMap<>();
    private final SectionManageService sectionManageService = new SectionManageService();

    public SectionManageController() {
        selectionNavigator.put(SectionManageSelection.ONE.getSelection(), this::registerSection);
        selectionNavigator.put(SectionManageSelection.TWO.getSelection(), this::deleteSection);
    }

    public void run() {
        String sectionManageSelection = Utils.requestInput(InputView::requestSectionManageSelection, OutputView::printErrorMessage);
        if (sectionManageSelection.equals(LineManageSelection.BACK.getSelection())) {
            return;
        }
        Runnable nextAction = selectionNavigator.get(sectionManageSelection);
        Utils.exceptionHandling(nextAction, OutputView::printErrorMessage);
    }

    private void registerSection() {
        String lineName = InputView.requestLineOfRegisterSection();
        String stationName = InputView.requestStationOfRegisterSection();
        int order = InputView.requestOrderOfRegisterSection();
        sectionManageService.registerSection(lineName, stationName, order);
        OutputView.printRegisterSection();

    }

    private void deleteSection() {
        String lineName = InputView.requestLineOfDeleteSection();
        String stationName = InputView.requestStationOfDeleteSection();
        sectionManageService.deleteSection(lineName, stationName);
        OutputView.printDeleteSection();
    }
}
