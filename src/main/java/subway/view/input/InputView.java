package subway.view.input;

import java.util.Scanner;
import subway.constants.menu.Menu;
import subway.domain.command.MainCommand;

public class InputView {

    static final Scanner scanner = new Scanner(System.in);

    public static MainCommand readMainMenu() {
        System.out.println(Menu.MAIN.getMenu());
        String command = scanner.nextLine();
        // validate
        return MainCommand.getMainCommand(command);
    }

}

