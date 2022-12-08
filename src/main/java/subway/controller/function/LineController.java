package subway.controller.function;

import java.util.function.Supplier;
import subway.constants.menu.Menu;
import subway.controller.ManagementController;
import subway.domain.command.ManageCommand;
import subway.service.LineService;
import subway.view.input.MainInputView;
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

    public String read(Supplier<String> readFunction) {
        try {
            return readFunction.get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return read(readFunction);
        }
    }

    @Override
    public void insert() {
        String name = read(() -> lineInputView.readLineName());
        String upStopStationName = read(() ->lineInputView.readUpStopStationName());
        String downStopStationName = read(()->lineInputView.readDownStopStationName());
        lineService.insert(name, upStopStationName, downStopStationName);
        lineOutputView.printInsertSuccess();
    }

    @Override
    public void delete() {
        lineService.delete(lineInputView.readDeleteLineName());
        lineOutputView.printDeleteSuccess();
    }

    @Override
    public void read() {
        lineOutputView.printLines(lineService.read());
    }

    public ManageCommand readCommand(Menu menu) {
        try {
            ManageCommand manageCommand = MainInputView.readManageMenu(menu);
            return manageCommand;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private void executeByCommand(ManageCommand manageCommand) {
        try {
           manageCommand.executeByCommand(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



}
