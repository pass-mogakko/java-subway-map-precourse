package subway.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import subway.service.LineManageService;
import subway.view.InputView;
import subway.view.LineManageSelection;
import subway.view.OutputView;

public class LineManageController {

    private final Map<String, Runnable> selectionNavigator = new HashMap<>();
    private final LineManageService lineManageService = new LineManageService();

    public LineManageController() {
        selectionNavigator.put(LineManageSelection.ONE.getSelection(), this::registerLine);
        selectionNavigator.put(LineManageSelection.TWO.getSelection(), this::deleteLine);
        selectionNavigator.put(LineManageSelection.THREE.getSelection(), this::lookupLine);
    }

    public void run() {
        try {
            String lineManageSelection = InputView.requestLineManageSelection();
            if (lineManageSelection.equals(LineManageSelection.BACK.getSelection())) {
                return;
            }
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
        OutputView.printRegisterLine();
    }

    private String requestRegisterLine() {
        try {
            String registerLine = InputView.requestRegisterLine();
            return registerLine;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return requestRegisterLine();
        }
    }

    private String requestRegisterLineFirstStation() {
        try {
            String firstStation = InputView.requestRegisterLineFirstStation();
            return firstStation;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return requestRegisterLineFirstStation();
        }
    }

    private String requestRegisterLineLastStation(String firstStation) {
        try {
            String lastStation = InputView.requestRegisterLineLastStation(firstStation);
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
            return;
        }
        OutputView.printDeleteLine();
    }

    private void lookupLine() {
        List<String> allLines = lineManageService.lookupLine();
        OutputView.printAllLines(allLines);
    }
}
