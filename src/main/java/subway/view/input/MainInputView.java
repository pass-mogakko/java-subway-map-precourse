package subway.view.input;

import subway.constants.menu.Menu;
import subway.domain.command.MainCommand;
import subway.domain.command.ManageCommand;
import subway.view.output.MainOutputView;
import subway.view.validator.CommandValidator;

public class MainInputView implements InputView {

    public static MainCommand readMainMenu() {
        MainOutputView.printMenu(Menu.MAIN);
        String command = scanner.nextLine();
        CommandValidator.validateCommand(command, Menu.MAIN);
        return MainCommand.getCommand(command);
    }

    public static ManageCommand readManageMenu(Menu menu) {
        MainOutputView.printMenu(menu);
        String command = scanner.nextLine();
        CommandValidator.validateCommand(command, menu);
        return ManageCommand.getCommand(command);
    }

}

