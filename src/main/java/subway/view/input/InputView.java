package subway.view.input;

import java.util.Scanner;
import subway.constants.menu.Menu;
import subway.domain.command.MainCommand;
import subway.domain.command.ManageCommand;
import subway.view.validator.CommandValidator;

public class InputView {

    static final Scanner scanner = new Scanner(System.in);

    public static MainCommand readMainMenu() {
        System.out.println(Menu.MAIN.getMenu());
        String command = scanner.nextLine();
        CommandValidator.validateCommand(command, Menu.MAIN);
        return MainCommand.getCommand(command);
    }

    public static ManageCommand readManageMenu(Menu menu) {
        System.out.println(menu.getMenu());
        String command = scanner.nextLine();
        CommandValidator.validateCommand(command, menu);
        return ManageCommand.getCommand(command);
    }

}

