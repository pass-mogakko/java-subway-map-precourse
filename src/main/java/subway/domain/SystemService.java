package subway.domain;

import subway.domain.line.LineController;
import subway.domain.section.LineSectionController;
import subway.domain.station.StationController;
import subway.domain.util.Validator;

public class SystemService {
//    private static HashMap<Integer, ?> commandMap;
    private static final String STATION_MANAGEMENT = "1";
    private static final String LINE_MANAGEMENT = "2";
    private static final String SECTION_MANAGEMENT = "3";
    private static final String SHOW_LINE_SECTION_MAP = "4";
    private static final String QUIT = "Q";

    private static final Validator validator = new Validator();

    private SystemService() {
//        commandMap.put("1", StationController.run());
    }

    public static void executeCommand(String command) {
        // 유효성 검사
        validator.validateMainInput(command);

        if (command.equals(STATION_MANAGEMENT)) StationController.run();
        if (command.equals(LINE_MANAGEMENT))    LineController.run();
        if (command.equals(SECTION_MANAGEMENT)) LineSectionController.run();
        if (command.equals(SHOW_LINE_SECTION_MAP)) LineSectionController.showMap();
        if (command.equals(QUIT)) return;
    }
}
