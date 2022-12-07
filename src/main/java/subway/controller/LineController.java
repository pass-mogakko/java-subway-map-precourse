package subway.controller;

import subway.command.LineCommand;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class LineController implements Controllable {
    private final Map<LineCommand, Runnable> lineRunnables;

    public LineController() {
        lineRunnables = new HashMap<>();

        lineRunnables.put(LineCommand.ADD, this::add);
        lineRunnables.put(LineCommand.REMOVE, this::remove);
        lineRunnables.put(LineCommand.SHOW, this::show);
    }

    @Override
    public void process() {
        LineCommand command = Repeater.repeatInput(this::selectCommand);

        while (!command.equals(LineCommand.BACK)) {
            Runnable runnable = lineRunnables.get(command);
            Repeater.repeatRun(runnable);

            command = Repeater.repeatInput(this::selectCommand);
        }
    }

    private LineCommand selectCommand() {
        final String input = Repeater.repeatInput(InputView::readLineMenu);

        return LineCommand.getCommand(input);
    }

    private void add() {
        final String lineName = Repeater.repeatInput(InputView::readAddLine);
        final String upTerminus = Repeater.repeatInput(InputView::readUpTerminus);
        final String downTerminus = Repeater.repeatInput(InputView::readDownTerminus);

        LineRepository.addLine(lineName, upTerminus, downTerminus);
    }

    private void remove() {
        final String lineName = Repeater.repeatInput(InputView::readRemoveLine);

        LineRepository.deleteLineByName(lineName);
    }

    private void show() {
        List<Line> lines = LineRepository.lines();
        List<String> lineNames = lines.stream()
                .map(Line::toString)
                .collect(Collectors.toList());

        OutputView.printLines(lineNames);
    }
}
