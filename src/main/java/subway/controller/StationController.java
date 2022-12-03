package subway.controller;

import static subway.controller.RunStatus.RUNNING;
import static subway.view.constants.OutputMessage.STATION_CREATE_INFO;
import static subway.view.constants.OutputMessage.STATION_DELETE_INFO;
import static subway.view.constants.SubCommand.BACK;
import static subway.view.constants.SubCommand.CREATE;
import static subway.view.constants.SubCommand.DELETE;
import static subway.view.constants.SubCommand.READ;

import java.util.List;
import subway.dto.StationDTO;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.constants.InputMessage;
import subway.view.constants.SubCommand;

public class StationController {

    private StationController() {
    }

    public static void run() {
        RunStatus runStatus = RUNNING;
        while (runStatus == RUNNING) {
            OutputView.printStationDisplay();
            SubCommand command = InputView.inputSubCommand();
            runStatus = runSelectedFunction(command);
        }
    }

    private static RunStatus runSelectedFunction(SubCommand command) {
        if (command == BACK) {
            return RunStatus.QUIT;
        }
        if (command == CREATE) {
            String name = InputView.inputName(InputMessage.STATION_CREATE_NAME_HEADER);
            StationService.addStation(new StationDTO(name));
            OutputView.printInfoMessage(STATION_CREATE_INFO);
        }
        if (command == DELETE) {
            String name = InputView.inputName(InputMessage.STATION_CREATE_NAME_HEADER);
            StationService.deleteStation(new StationDTO(name));
            OutputView.printInfoMessage(STATION_DELETE_INFO);
        }
        if (command == READ) {
            List<StationDTO> stationDTOs = StationService.getAllStations();
            OutputView.printStations(stationDTOs);
        }
        return RUNNING;
    }
}