package subway.domain.line;

import subway.domain.util.ExceptionHandler;
import subway.domain.util.MessageFactory;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.domain.line.LineCommand.*;
import static subway.domain.util.InfoCode.*;

public class LineController {
    private final LineService lineService = new LineService();
    private final MessageFactory messageFactory = new MessageFactory();

    public void setUp() {
        lineService.setUp();
    }

    public void run() {
        OutputView.printLinePage();
        String input = ExceptionHandler.repeatForValidInput(InputView::readDetailCommand);
        executeCommand(input);
    }

    private void executeCommand(String input) {
        LineCommand command = getCode(input);

        if (command == ADD_LINE) addLine();
        if (command == DELETE_LINE) deleteLine();
        if (command == SHOW_LINE) showAllLines();
        if (command == BACK) return;
    }

    private void addLine() {
        String lineName = ExceptionHandler.repeatForValidInput(InputView::readLineNameToAdd);
        String upFinalStation = ExceptionHandler.repeatForValidInput(InputView::readUpFinalStation);
        String downFinalStation = ExceptionHandler.repeatForValidInput(InputView::readDownFinalStation);
        lineService.addLine(lineName, upFinalStation, downFinalStation);
        OutputView.print(messageFactory.makeInfoMessage(LINE_ADDITION_COMPLETE));
    }

    private void deleteLine() {
        String lineName = ExceptionHandler.repeatForValidInput(InputView::readLineNameToDelete);
        lineService.deleteLine(lineName);
        OutputView.print(messageFactory.makeInfoMessage(LINE_DELETION_COMPLETE));
    }

    private void showAllLines() {
        String result = lineService.showAllLines();
        OutputView.print(result);
    }

}
