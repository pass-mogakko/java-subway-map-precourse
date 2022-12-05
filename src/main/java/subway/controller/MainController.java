package subway.controller;

import subway.domain.Function;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class MainController {
    private static final StationController stationController = new StationController();
    private static final LineController lineController = new LineController();
    private static final SectionController sectionController = new SectionController();
    private static final LineMapController mapController = new LineMapController();

    public MainController() {
    }

    public static void viewMain() {
        printMainView();
        final String function = readFunction();
        runMain(function);
    }

    private static void runMain(String function) {
        if (Function.isManageStation(function)) {
            stationController.run();
        }
        if (Function.isManageLine(function)) {
            lineController.run();
        }
        if (Function.isManageSection(function)) {
            sectionController.run();
        }
        if (Function.isPrintLineMap(function)) {
            mapController.viewMap();
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
