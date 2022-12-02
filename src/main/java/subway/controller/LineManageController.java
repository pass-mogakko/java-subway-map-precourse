package subway.controller;

import java.util.HashMap;
import java.util.Map;
import subway.service.LineManageService;
import subway.view.InputView;
import subway.view.LineManageSelection;
import subway.view.OutputView;

public class LineManageController {

    private final LineManageService lineManageService = new LineManageService();
    private final Map<String, Runnable> selectionNavigator = new HashMap<>();

    public LineManageController() {
        selectionNavigator.put(LineManageSelection.ONE.getSelection(), this::registerLine);
    }

    public void run() {
        try {
            String lineManageSelection = InputView.requestLineManageSelection();
            selectionNavigator.get(lineManageSelection)
                    .run();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            run();
        }

    }

    private void registerLine() {
        String registerLine = requestRegisterLine();
    }

    private String requestRegisterLine() {
        try {
            String registerLine = InputView.requestRegisterLine();
            LineManageService.validateIsExistLine(registerLine);
            return registerLine;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return requestRegisterLine();
        }
    }
}
