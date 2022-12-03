package subway.controller;

import subway.domain.Function;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class MainController {
    private static final StationController stationController = new StationController();

    public void viewMain() {
        printMainView();
        final String function = readFunction();
        run(function);
    }

    private void run(String function) {
        if (Function.isManageStation(function)) {
            stationController.run();
        }
        if(Function.isManageLine(function)){

        }
    }

    private String readFunction() {
        try {
            String function = InputView.inputFunction();
            return Function.find(function);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readFunction();
        }
    }

    private void printMainView() {
        List<String> functions = Function.getFunctions();
        OutputView.printMainView(functions);
    }
}
