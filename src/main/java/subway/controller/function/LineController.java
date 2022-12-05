package subway.controller.function;

import subway.constants.menu.Menu;
import subway.controller.ManagementController;
import subway.domain.command.ManageCommand;
import subway.view.input.InputView;

public class LineController implements ManagementController {

    @Override
    public void execute() {
        while (true) {
            ManageCommand manageCommand = readCommand(Menu.LINE);
            if (manageCommand == null) {
                continue;
            }
            if (manageCommand.equals(ManageCommand.BACK)) {
                break;
            }
            executeByCommand(manageCommand);
        }
    }

    public ManageCommand readCommand(Menu menu) {
        try {
            ManageCommand manageCommand = InputView.readManageMenu(menu);
            return manageCommand;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private void executeByCommand(ManageCommand manageCommand) {
        if (manageCommand.equals(ManageCommand.INSERT)) {
            insert();
        }
        if (manageCommand.equals(ManageCommand.DELETE)) {
            delete();
        }
        if (manageCommand.equals(ManageCommand.READ)) {
            read();
        }
    }

    private void insert() {

    }

    private void delete() {

    }

    private void read() {

    }
}
