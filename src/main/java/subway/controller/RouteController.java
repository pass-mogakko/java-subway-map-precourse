package subway.controller;

import subway.command.RouteCommand;
import subway.view.InputView;



public class RouteController {
    public void process() {
        RouteCommand command = selectCommand();

        if (command.equals(RouteCommand.BACK)) {
            return;
        }

        if (command.equals(RouteCommand.ADD)) {

        }

        if (command.equals(RouteCommand.REMOVE)) {

        }
    }

    private RouteCommand selectCommand() {
        while (true) {
            try {
                final String input = InputView.readLineMenu();
                final RouteCommand command = RouteCommand.getCommand(input);

                return command;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
