package subway.controller;

import java.util.HashMap;
import java.util.Map;
import subway.service.SectionManageService;
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
        try {
            String sectionManageSelection = InputView.requestSectionManageSelection();
            if (sectionManageSelection.equals(LineManageSelection.BACK.getSelection())) {
                return;
            }
            Runnable nextAction = selectionNavigator.get(sectionManageSelection);
            nextAction.run();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            run();
        }
    }

    private void registerSection() {
        String lineName = requestLineOfRegisterSection();
        String stationName = requestStationOfRegisterSection();
        int order = requestOrderOfRegisterSection();
        sectionManageService.registerSection(lineName, stationName, order);
        OutputView.printRegisterSection();
    }

    private String requestLineOfRegisterSection() {
        try {
            String line = InputView.requestLineOfRegisterSection();
            return line;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return requestLineOfRegisterSection();
        }
    }

    private String requestStationOfRegisterSection() {
        try {
            String stationName = InputView.requestStationOfRegisterSection();
            return stationName;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return requestStationOfRegisterSection();
        }
    }

    private int requestOrderOfRegisterSection() {
        try {
            int order = InputView.requestOrderOfRegisterSection();
            return order;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return requestOrderOfRegisterSection();
        }
    }

    private void deleteSection() {
        String lineName = requestLineOfDeleteSection();
        String stationName = requestStationOfDeleteSection();
        sectionManageService.deleteSection(lineName, stationName);
        OutputView.printDeleteSection();
    }

    private String requestLineOfDeleteSection() {
        try {
            String lineName = InputView.requestLineOfDeleteSection();
            return lineName;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return requestLineOfDeleteSection();
        }
    }

    private String requestStationOfDeleteSection() {
        try {
            String stationName = InputView.requestStationOfDeleteSection();
            return stationName;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return requestStationOfDeleteSection();
        }
    }
}
