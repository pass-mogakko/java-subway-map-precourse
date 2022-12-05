package subway.view.input;

import java.util.Scanner;
import subway.constants.menu.Menu;
import subway.domain.command.MainCommand;
import subway.domain.command.ManageCommand;
import subway.view.output.OutputView;
import subway.view.validator.CommandValidator;

public class InputView {

    static final Scanner scanner = new Scanner(System.in);

    public static MainCommand readMainMenu() {
        OutputView.printMenu(Menu.MAIN);
        String command = scanner.nextLine();
        CommandValidator.validateCommand(command, Menu.MAIN);
        return MainCommand.getCommand(command);
    }

    public static ManageCommand readManageMenu(Menu menu) {
        OutputView.printMenu(menu);
        String command = scanner.nextLine();
        CommandValidator.validateCommand(command, menu);
        return ManageCommand.getCommand(command);
    }

    public static String readNewStation() {
        return scanner.nextLine();
    }

}

