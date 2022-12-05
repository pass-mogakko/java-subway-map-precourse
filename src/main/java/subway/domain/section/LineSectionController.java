package subway.domain.section;

import subway.domain.util.ExceptionHandler;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.domain.section.LineSectionCommand.*;

public class LineSectionController {
    private static final LineSectionService lineSectionService = new LineSectionService();

    public void setUp() {
        lineSectionService.setUp();
    }

    public void run() {
        OutputView.printSectionPage();
        String input = ExceptionHandler.repeatForValidInput(InputView::readSectionCommand);
        executeCommand(input);
    }

    private void executeCommand(String input) {
        LineSectionCommand command = getCode(input);

//        if (command == ADD_SECTION) addSection();
//        if (command == DELETE_SECTION) deleteSection();
        if (command == BACK) return;
    }

    public void showMap() {
    }
}
