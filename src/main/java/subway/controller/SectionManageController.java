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
        String lineName = requestLine();
        String stationName = requestStation(lineName);
        int order = requestOrder(lineName);
        sectionManageService.registerSection(lineName, stationName, order);
        OutputView.printRegisterSection();
    }

    private String requestLine() {
        try {
            String line = InputView.requestLine();
            lineManageService.validateIsRegisterLine(line);
            return line;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return requestLine();
        }
    }

    private String requestStation(String lineName) {
        try {
            String stationName = InputView.requestStation();
            stationManageService.validateIsRegisterStation(stationName);
            sectionManageService.validateIsAlreadySection(lineName, stationName);
            return stationName;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return requestStation(lineName);
        }
    }

    private int requestOrder(String lineName) {
        try {
            int order = InputView.requestOrder();
            sectionManageService.validateIsPossibleOrder(lineName, order);
            return order;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return requestOrder(lineName);
        }
    }
}
