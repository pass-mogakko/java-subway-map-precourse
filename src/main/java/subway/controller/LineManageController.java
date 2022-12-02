package subway.controller;

import java.util.HashMap;
import java.util.Map;
import subway.service.LineManageService;
import subway.view.InputView;
import subway.view.LineManageSelection;

public class LineManageController {

    private final LineManageService lineManageService = new LineManageService();
    private final Map<String, Runnable> selectionNavigator = new HashMap<>();

    public LineManageController() {
        selectionNavigator.put(LineManageSelection.ONE.getSelection(), this::registerLine);
    }

    public void run() {
        String lineManageSelection = InputView.requestLineManageSelection();
        selectionNavigator.get(lineManageSelection)
                .run();
    }

    private void registerLine() {
        String registerLine = InputView.requestRegisterLine();
    }
}
