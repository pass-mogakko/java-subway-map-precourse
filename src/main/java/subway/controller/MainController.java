package subway.controller;

import subway.domain.Function;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class MainController {

    public void view() {
        printMainView();
        final String function = readFunction();
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
