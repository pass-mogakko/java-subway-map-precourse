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
        ManageCommand manageCommand = readCommand(Menu.STATION);
        if (manageCommand.equals(ManageCommand.BACK)) {
            return;
        }
        executeByCommand(manageCommand);
        execute();
    }

    public ManageCommand readCommand(Menu menu) {
        try {
            ManageCommand manageCommand = MainInputView.readManageMenu(menu);
            return manageCommand;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readCommand(menu);
        }
    }

    private void executeByCommand(ManageCommand manageCommand) {
        try {
            manageCommand.executeByCommand(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insert() {
        stationService.insertStation(stationInputView.readNewStationName());
        stationOutputView.printInsertSuccess();
    }

    @Override
    public void delete() {
        stationService.delete(stationInputView.readDeleteStationName());
        stationOutputView.printDeleteSuccess();
    }

    @Override
    public void read() {
        stationOutputView.printStations(stationService.read());
    }

}
