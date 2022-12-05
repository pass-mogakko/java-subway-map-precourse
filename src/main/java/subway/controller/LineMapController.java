package subway.controller;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.view.OutputView;

import java.util.List;

public class LineMapController {
    private static final List<Line> lines = LineRepository.lines();

    public void viewMap() {
        OutputView.printLineMapText();
        printLineMap();
        MainController.viewMain();
    }

    private void printLineMap() {
        for (Line line : lines) {
            OutputView.printLineName(line.getName());
            OutputView.printStations(line.getStations());
        }
    }
}
