package subway.controller;

import subway.domain.Function;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class MainController {
    private static final StationController stationController = new StationController();

    public static void viewMain() {
        printMainView();
        final String function = readFunction();
        runMain(function);
    }

    private static void runMain(String function) {
        if (Function.isManageStation(function)) {
            stationController.run();
        }
        if(Function.isManageLine(function)){

        }
    }

    private static String readFunction() {
        try {
            String function = InputView.inputFunction();
            return Function.find(function);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readFunction();
        }
    }

    private static void printMainView() {
        List<String> functions = Function.getFunctions();
        OutputView.printMainView(functions);
    }
}
