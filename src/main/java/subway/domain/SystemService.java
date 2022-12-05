package subway.domain;

import subway.domain.line.LineController;
import subway.domain.section.LineSectionController;
import subway.domain.station.StationController;
import subway.domain.util.ErrorCode;
import subway.domain.util.MessageFactory;

import java.util.List;

public class SystemService {
//    private static HashMap<Integer, ?> commandMap;
    private final static List<String> MAIN_COMMAND_VALID_RANGE = List.of("1", "2", "3", "4", "Q");
    private static final String STATION_MANAGEMENT = "1";
    private static final String LINE_MANAGEMENT = "2";
    private static final String SECTION_MANAGEMENT = "3";
    private static final String SHOW_LINE_SECTION_MAP = "4";
    private static final String QUIT = "Q";

    private static final StationController stationController = new StationController();
    private static final LineController lineController = new LineController();
    private static final LineSectionController lineSectionController = new LineSectionController();
    private static final MessageFactory messageFactory = new MessageFactory();

//    private SystemService() {
////        commandMap.put("1", StationController.run());
//    }

    public void validateCommand(String input) {
        if (!MAIN_COMMAND_VALID_RANGE.contains(input)) {
            throw new IllegalArgumentException(messageFactory.makeErrorMessage(ErrorCode.INVALID_COMMAND));
        }
    }

    public void executeCommand(SystemCommand command) {
        if (command.equals(SystemCommand.STATION_MANAGEMENT)) stationController.run();
        if (command.equals(SystemCommand.LINE_MANAGEMENT))    lineController.run();
        if (command.equals(SystemCommand.SECTION_MANAGEMENT)) lineSectionController.run();
        if (command.equals(SystemCommand.SHOW_LINE_SECTION_MAP)) lineSectionController.showMap();
        if (command.equals(SystemCommand.QUIT)) return;
    }
}
