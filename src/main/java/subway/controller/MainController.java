package subway.controller;


import subway.command.MainCommand;
import subway.view.InputView;



public class MainController {
    public void run() {
        while(true) {
            final MainCommand command = selectCommand();

            if (command.equals(MainCommand.QUIT)) {
                return;
            }

            if (command.equals(MainCommand.STATION)) {

            }

            if (command.equals(MainCommand.LINE)) {

            }

            if (command.equals(MainCommand.ROUTE)) {

            }

            if (command.equals(MainCommand.SHOW)) {
                
            }
        }
    }

    private MainCommand selectCommand() {
        while (true) {
            try {
                final String input = InputView.readMainMenu();
                final MainCommand command = MainCommand.getCommand(input);

                return command;
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }
    }
}
