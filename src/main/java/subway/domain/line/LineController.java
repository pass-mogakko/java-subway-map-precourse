package subway.domain.line;

import subway.domain.util.ExceptionHandler;
import subway.view.InputView;
import subway.view.OutputView;

public class LineController {
    private final LineService lineService = new LineService();

    public void setUp() {
        lineService.setUp();
    }

    public void run(){
        OutputView.printLinePage();
        String input = ExceptionHandler.repeatForValidInput(InputView::readDetailCommand);
//        executeCommand(input);
    }

//    private void executeCommand(String input) {
//        LineCommand command = getCode(input);
//
//        if (command == ADD_LINE) addLine();
//        if (command == DELETE_LINE) deleteLine();
//        if (command == SHOW_LINE) showAllLines();
//        if (command == BACK) return;
//    }
//
//    private void addLine() {
//        String lineName = ExceptionHandler.repeatForValidInput(InputView::readLineNameToAdd);
//        lineService.addLine(lineName);
//        OutputView.print(messageFactory.makeInfoMessage(ADD_STATION_COMPLETE));
//    }
}
