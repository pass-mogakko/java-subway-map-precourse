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

    private void add() {
        final String lineName = addLine();
        final String upTerminus = getUpTerminusName();
        final String downTerminus = getDownTerminusName();

        Route route = new Route(lineName, List.of(upTerminus, downTerminus));

        RouteRepository.addRoute(route);
    }

    private String addLine() {
        while (true) {
            try {
                final String lineName = InputView.readAddLine();

                return lineName;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private String getDownTerminusName() {
        while (true) {
            try {
                final String downTerminusName = InputView.readDownTerminus();

                return downTerminusName;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private String getUpTerminusName() {
        while (true) {
            try {
                final String upTerminusName = InputView.readUpTerminus();

                return upTerminusName;
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

                return;
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
