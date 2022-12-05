package subway.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import subway.service.LineManageService;
import subway.utils.Utils;
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
        String lineManageSelection = Utils.requestInput(InputView::requestLineManageSelection, OutputView::printErrorMessage);
        if (lineManageSelection.equals(LineManageSelection.BACK.getSelection())) {
            return;
        }
        Runnable nextAction = selectionNavigator.get(lineManageSelection);
        Utils.exceptionHandling(nextAction, OutputView::printErrorMessage);
    }

    private void registerLine() {
        String registerLine = InputView.requestRegisterLine();
        String firstStation = InputView.requestRegisterLineFirstStation();
        String lastStation = InputView.requestRegisterLineLastStation();
        lineManageService.registerLine(registerLine, firstStation, lastStation);
        OutputView.printRegisterLine();

    }

    private void deleteLine() {
        String deleteLine = InputView.requestDeleteLine();
        lineManageService.deleteLine(deleteLine);
        OutputView.printDeleteLine();
    }

    private void lookupLine() {
        List<String> allLines = lineManageService.lookupLine();
        OutputView.printAllLines(allLines);
    }
}
