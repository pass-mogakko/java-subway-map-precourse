package subway.controller.function;

import subway.constants.menu.Menu;
import subway.controller.ManagementController;
import subway.domain.command.ManageCommand;
import subway.service.StationService;
import subway.view.input.MainInputView;
import subway.view.input.StationInputView;
import subway.view.output.StationOutputView;

public class StationController implements ManagementController {

    private final StationService stationService = new StationService();
    private final StationInputView stationInputView = new StationInputView();
    private final StationOutputView stationOutputView = new StationOutputView();

    @Override
    public void execute() {
        while (true) {
            ManageCommand manageCommand = readCommand(Menu.STATION);
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
            ManageCommand manageCommand = MainInputView.readManageMenu(menu);
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

    public void insert(ManageCommand manageCommand) {
        if (manageCommand.equals(ManageCommand.INSERT)) {
            stationService.insertStation(stationInputView.readStationName());
            stationOutputView.printInsertSuccess();
        }
    }

    public void delete(ManageCommand manageCommand) {
        if (manageCommand.equals(ManageCommand.DELETE)) {
            stationService.delete(stationInputView.readDeleteStationName());
            stationOutputView.printDeleteSuccess();
        }
    }

    public void read(ManageCommand manageCommand) {
        if (manageCommand.equals(ManageCommand.READ)) {
            stationOutputView.printStations(stationService.read());
        }
    }

}
