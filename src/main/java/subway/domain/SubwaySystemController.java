package subway.domain;

import subway.domain.section.LineSectionController;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwaySystemController {

    private SubwaySystemController() {
        LineSectionController.setUp();
    }

    public static void run() {
        OutputView.printMain();
        String input = InputView.readMainCommand();
        SubwaySystemService.executeCommand(input);
    }
}
