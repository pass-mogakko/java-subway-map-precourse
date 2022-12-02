package subway.controller;

import java.util.HashMap;
import java.util.Map;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionManageController {

    private final Map<String, Runnable> selectionNavigator = new HashMap<>();

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
}
