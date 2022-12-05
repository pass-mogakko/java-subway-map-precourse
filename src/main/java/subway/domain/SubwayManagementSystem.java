package subway.domain;

import subway.domain.section.LineSectionController;
import subway.view.OutputView;

public class SubwayManagementSystem {

    private SubwayManagementSystem() {
        LineSectionController.setUp();
    }

    public static void run() {
        OutputView.printMain();
    }
}
