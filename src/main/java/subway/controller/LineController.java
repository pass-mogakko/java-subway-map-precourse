package subway.controller;

import subway.command.LineCommand;
import subway.command.StationCommand;
import subway.view.InputView;



public class LineController {
    public void process() {
        final LineCommand command = selectCommand();

        if (command.equals(LineCommand.BACK)) {
            return;
        }

        if (command.equals(LineCommand.ADD)) {
            // TODO: 노선 추가
        }

        if (command.equals(LineCommand.REMOVE)) {
            // TODO: 노선 삭제
        }

        if (command.equals(LineCommand.SHOW)) {
            // TODO: 노선 조회
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
}
