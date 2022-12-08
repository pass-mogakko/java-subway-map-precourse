package subway.controller;

import static subway.controller.RunStatus.RUNNING;
import static subway.controller.RunStatus.STOPPED;
import static subway.view.constants.InputMessage.STATION_CREATE_NAME_HEADER;
import static subway.view.constants.InputMessage.STATION_DELETE_NAME_HEADER;
import static subway.view.constants.OutputMessage.STATION_CREATE_INFO;
import static subway.view.constants.OutputMessage.STATION_DELETE_INFO;
import static subway.view.constants.menu.SubCommand.BACK;
import static subway.view.constants.menu.SubCommand.CREATE;
import static subway.view.constants.menu.SubCommand.DELETE;
import static subway.view.constants.menu.SubCommand.READ;

import java.util.List;
import subway.dto.StationDTO;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.constants.menu.SubCommand;

public class StationController implements Controller {
    private static final StationService stationService = StationService.getInstance();
    private static StationController instance;

    private StationController() {
    }

    public static StationController getInstance() {
        if (instance == null) {
            instance = new StationController();
        }
        return instance;
    }

    @Override
    public void execute() {
        RunStatus runStatus = RUNNING;
        while (runStatus == RUNNING) {
            OutputView.printStationMenus();
            SubCommand command = InputView.inputSubCommand();
            runStatus = runSelectedMenu(command);
        }
    }

    private RunStatus runSelectedMenu(SubCommand command) {
        if (command == BACK) {
            return STOPPED;
        }
        if (command == CREATE) {
            createStation();
        }
        if (command == DELETE) {
            deleteStation();
        }
        if (command == READ) {
            readStations();
        }
        return RUNNING;
    }

    private void createStation() {
        String name = InputView.inputName(STATION_CREATE_NAME_HEADER);
        stationService.addStation(new StationDTO(name));
        OutputView.printInfoMessage(STATION_CREATE_INFO);
    }

    private void deleteStation() {
        String name = InputView.inputName(STATION_DELETE_NAME_HEADER);
        stationService.deleteStation(new StationDTO(name));
        OutputView.printInfoMessage(STATION_DELETE_INFO);
    }

    private void readStations() {
        List<StationDTO> stationDTOs = stationService.getAllStations();
        OutputView.printStations(stationDTOs);
    }
}