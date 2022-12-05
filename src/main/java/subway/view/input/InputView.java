package subway.view.input;

import java.util.Scanner;
import subway.constants.menu.Menu;
import subway.domain.command.MainCommand;
import subway.domain.command.ManageCommand;

public class InputView {

    static final Scanner scanner = new Scanner(System.in);

    public static MainCommand readMainMenu() {
        System.out.println(Menu.MAIN.getMenu());
        String command = scanner.nextLine();
        // validate
        return MainCommand.getMainCommand(command);
    }

    public static ManageCommand readManageMenu(Menu menu) {
        System.out.println(menu.getMenu());
        String command = scanner.nextLine();
        // validate
        return ManageCommand.getCommand(command);
    }

}

