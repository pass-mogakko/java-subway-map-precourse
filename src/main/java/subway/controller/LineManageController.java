package subway.controller;

import java.util.HashMap;
import java.util.Map;
import subway.service.LineManageService;
import subway.service.StationManageService;
import subway.view.InputView;
import subway.view.LineManageSelection;
import subway.view.OutputView;

public class LineManageController {

    private final Map<String, Runnable> selectionNavigator = new HashMap<>();
    private final LineManageService lineManageService = new LineManageService();
    private final StationManageService stationManageService = new StationManageService();

    public LineManageController() {
        selectionNavigator.put(LineManageSelection.ONE.getSelection(), this::registerLine);
        selectionNavigator.put(LineManageSelection.TWO.getSelection(), this::deleteLine);
    }

    public void run() {
        try {
            String lineManageSelection = InputView.requestLineManageSelection();
            Runnable nextAction = selectionNavigator.get(lineManageSelection);
            nextAction.run();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            run();
        }
    }

    private void registerLine() {
        String registerLine = requestRegisterLine();
        String firstStation = requestRegisterLineFirstStation();
        String lastStation = requestRegisterLineLastStation(firstStation);
        LineManageService.registerLine(registerLine, firstStation, lastStation);
    }

    private String requestRegisterLine() {
        try {
            String registerLine = InputView.requestRegisterLine();
            lineManageService.validateIsUnregisterLine(registerLine);
            return registerLine;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return requestRegisterLine();
        }
    }

    private String requestRegisterLineFirstStation() {
        try {
            String firstStation = InputView.requestRegisterLineFirstStation();
            stationManageService.validateIsRegisterStation(firstStation);
            return firstStation;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return requestRegisterLineFirstStation();
        }
    }

    private String requestRegisterLineLastStation(String firstStation) {
        try {
            String lastStation = InputView.requestRegisterLineLastStation(firstStation);
            stationManageService.validateIsRegisterStation(lastStation);
            return lastStation;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return requestRegisterLineLastStation(firstStation);
        }
    }

    private void deleteLine() {
        try {
            String deleteLine = InputView.requestDeleteLine();
            lineManageService.deleteLine(deleteLine);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            deleteLine();
        }
    }
}
