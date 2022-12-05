package subway.domain.section;

import subway.domain.util.ExceptionHandler;
import subway.domain.util.MessageFactory;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.domain.section.LineSectionCommand.*;
import static subway.domain.util.InfoCode.SECTION_ADDITION_COMPLETE;
import static subway.domain.util.InfoCode.SECTION_DELETION_COMPLETE;

public class LineSectionController {
    private static final LineSectionService lineSectionService = new LineSectionService();
    private final MessageFactory messageFactory = new MessageFactory();

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
        if (command == ADD_SECTION) addSection();
        if (command == DELETE_SECTION) deleteSection();
        if (command == BACK) return;
    }

    private void addSection() {
        String lineName = InputView.readLineName();
        String stationName = InputView.readStationName();
        int order = InputView.readSectionOrder();
        lineSectionService.addSection(lineName, stationName, order);

        OutputView.print(messageFactory.makeInfoMessage(SECTION_ADDITION_COMPLETE));
    }

    private void deleteSection() {
        String lineName = InputView.readLineName();
        String stationName = InputView.readStationName();
        lineSectionService.deleteSection(lineName, stationName);

        OutputView.print(messageFactory.makeInfoMessage(SECTION_DELETION_COMPLETE));
    }

    public void showMap() {
        String result = lineSectionService.showMap();
        OutputView.print(result);
    }
}
