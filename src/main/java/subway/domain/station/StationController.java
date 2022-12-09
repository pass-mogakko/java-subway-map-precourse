package subway.domain.station;

import static subway.controller.RunStatus.RUNNING;
import static subway.controller.RunStatus.STOPPED;
import static subway.view.constants.InputMessage.STATION_CREATE_NAME_HEADER;
import static subway.view.constants.InputMessage.STATION_DELETE_NAME_HEADER;
import static subway.view.constants.OutputMessage.STATION_CREATE_INFO;
import static subway.view.constants.OutputMessage.STATION_DELETE_INFO;
import static subway.view.constants.menu.SubCommand.BACK;

import java.util.List;
import subway.controller.ErrorInterceptor;
import subway.controller.HandlerAdaptor;
import subway.controller.ManageController;
import subway.controller.RunStatus;
import subway.dto.StationDTO;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.constants.menu.SubCommand;

public class StationController extends ManageController {
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
    protected void execute() {
        RunStatus runStatus = RUNNING;
        while (runStatus == RUNNING) {
            OutputView.printStationMenus();
            SubCommand command = ErrorInterceptor.repeatUntilGetLegalAnswer(InputView::inputSubCommand);
            runStatus = runSelectedMenu(command);
        }
    }

    private RunStatus runSelectedMenu(SubCommand command) {
        if (command == BACK) {
            return STOPPED;
        }
        HandlerAdaptor.executeFunctionByCommand(instance, command);
        return RUNNING;
    }

    @Override
    protected void create() {
        String name = InputView.inputName(STATION_CREATE_NAME_HEADER);
        stationService.addStation(new StationDTO(name));
        OutputView.printInfoMessage(STATION_CREATE_INFO);
    }

    @Override
    protected void delete() {
        String name = InputView.inputName(STATION_DELETE_NAME_HEADER);
        stationService.deleteStation(new StationDTO(name));
        OutputView.printInfoMessage(STATION_DELETE_INFO);
    }

    @Override
    protected void read() {
        List<StationDTO> stationDTOs = stationService.getAllStations();
        OutputView.printStations(stationDTOs);
    }
}