package subway.domain.global;

import subway.domain.line.LineController;
import subway.domain.section.LineSectionController;
import subway.domain.station.StationController;
import static subway.domain.global.SystemCommand.*;

public class SystemService {
    private static final StationController stationController = new StationController();
    private static final LineController lineController = new LineController();
    private static final LineSectionController lineSectionController = new LineSectionController();

    public void executeCommand(String input) {
        SystemCommand command = convertToCommand(input);

        if (command == STATION_MANAGEMENT) stationController.run();
        if (command == LINE_MANAGEMENT)    lineController.run();
        if (command == SECTION_MANAGEMENT) lineSectionController.run();
        if (command == SHOW_LINE_SECTION_MAP) lineSectionController.showMap();
    }
}
