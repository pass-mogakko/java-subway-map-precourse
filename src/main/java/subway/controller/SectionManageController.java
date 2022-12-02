package subway.controller;

import java.util.HashMap;
import java.util.Map;
import subway.service.LineManageService;
import subway.service.SectionManageService;
import subway.service.StationManageService;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.SectionManageSelection;

public class SectionManageController {

    private final Map<String, Runnable> selectionNavigator = new HashMap<>();
    private final StationManageService stationManageService = new StationManageService();
    private final LineManageService lineManageService = new LineManageService();
    private final SectionManageService sectionManageService = new SectionManageService();

    public SectionManageController() {
        selectionNavigator.put(SectionManageSelection.ONE.getSelection(), this::registerSection);
        selectionNavigator.put(SectionManageSelection.TWO.getSelection(), this::deleteSection);
    }

    public void run() {
        try {
            String lineManageSelection = InputView.requestSectionManageSelection();
            Runnable nextAction = selectionNavigator.get(lineManageSelection);
            nextAction.run();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            run();
        }
    }

    private void registerSection() {
        String lineName = requestLineOfRegisterSection();
        String stationName = requestStationOfRegisterSection(lineName);
        int order = requestOrderOfRegisterSection(lineName);
        sectionManageService.registerSection(lineName, stationName, order);
        OutputView.printRegisterSection();
    }

    private String requestLineOfRegisterSection() {
        try {
            String line = InputView.requestLineOfRegisterSection();
            lineManageService.validateIsRegisterLine(line);
            return line;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return requestLineOfRegisterSection();
        }
    }

    private String requestStationOfRegisterSection(String lineName) {
        try {
            String stationName = InputView.requestStationOfRegisterSection();
            stationManageService.validateIsRegisterStation(stationName);
            sectionManageService.validateIsRegisterSection(lineName, stationName);
            return stationName;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return requestStationOfRegisterSection(lineName);
        }
    }

    private int requestOrderOfRegisterSection(String lineName) {
        try {
            int order = InputView.requestOrderOfRegisterSection();
            sectionManageService.validateIsPossibleOrder(lineName, order);
            return order;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return requestOrderOfRegisterSection(lineName);
        }
    }

    private void deleteSection() {
        String lineName = requestLineOfDeleteSection();
        String stationName = requestStationOfDeleteSection(lineName);
        sectionManageService.deleteSection(lineName, stationName);
        OutputView.printDeleteSection();
    }

    private String requestLineOfDeleteSection() {
        try {
            String lineName = InputView.requestLineOfDeleteSection();
            lineManageService.validateIsRegisterLine(lineName);
            sectionManageService.validateIsPossibleDelete(lineName);
            return lineName;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return requestLineOfDeleteSection();
        }
    }

    private String requestStationOfDeleteSection(String lineName) {
        try {
            String stationName = InputView.requestStationOfDeleteSection();
            stationManageService.validateIsRegisterStation(stationName);
            sectionManageService.validateIsUnregisterSection(lineName, stationName);
            return stationName;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return requestStationOfDeleteSection(lineName);
        }
    }
}
