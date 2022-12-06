package subway.controller;

import java.util.List;
import java.util.stream.Collectors;
import subway.command.LineCommand;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;



public class LineController {
    public void process() {
        final LineCommand command = selectCommand();

        if (command.equals(LineCommand.BACK)) {
            return;
        }

        if (command.equals(LineCommand.ADD)) {
            add();
        }

        if (command.equals(LineCommand.REMOVE)) {
            remove();
        }

        if (command.equals(LineCommand.SHOW)) {
            show();
        }
    }

    private LineCommand selectCommand() {
        while(true) {
            try {
                final String input = InputView.readLineMenu();
                final LineCommand command = LineCommand.getCommand(input);

                return command;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private Line add() {
        while (true) {
            try {
                final String input = InputView.readAddLine();
                final Line line = new Line(input);

                LineRepository.addLine(line);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void remove() {
        while (true) {
            try {
                final String input = InputView.readRemoveLine();

                LineRepository.deleteLineByName(input);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void show() {
        List<Line> lines = LineRepository.lines();
        List<String> lineNames = lines.stream()
                .map(Line::toString)
                .collect(Collectors.toList());

        OutputView.printLines(lineNames);
    }
}
