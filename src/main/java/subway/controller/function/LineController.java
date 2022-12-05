package subway.controller.function;

import subway.constants.menu.Menu;
import subway.controller.ManagementController;
import subway.domain.command.ManageCommand;
import subway.service.LineService;
import subway.view.input.InputView;
import subway.view.input.LineInputView;
import subway.view.output.LineOutputView;

public class LineController implements ManagementController {

    private final LineService lineService = new LineService();
    private final LineInputView lineInputView = new LineInputView();
    private final LineOutputView lineOutputView = new LineOutputView();

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
            break;
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
        try {
            insert(manageCommand);
            delete(manageCommand);
            read(manageCommand);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void insert(ManageCommand manageCommand) {
        if (manageCommand.equals(ManageCommand.INSERT)) {
            String name = lineInputView.readLineName();
            String upStopStationName = lineInputView.readUpStopStationName();
            String downStopStationName = lineInputView.readDownStopStationName();
            lineService.insert(name, upStopStationName, downStopStationName);
            lineOutputView.printInsertSuccess();
        }
    }

    private void delete(ManageCommand manageCommand) {
        if (manageCommand.equals(ManageCommand.DELETE)) {
            lineService.delete(lineInputView.readDeleteLineName());
            lineOutputView.printDeleteSuccess();
        }
    }

    private void read(ManageCommand manageCommand) {
        if (manageCommand.equals(ManageCommand.READ)) {
            lineOutputView.printLines(lineService.read());
        }
    }
}
