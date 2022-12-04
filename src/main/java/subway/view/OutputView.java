package subway.view;

import static subway.view.ConsolePrinter.printInfo;
import static subway.view.constants.OutputMessage.BORDER_LINE;
import static subway.view.constants.OutputMessage.LINE_DISPLAY_HEADER;
import static subway.view.constants.OutputMessage.LINE_READ_HEADER;
import static subway.view.constants.OutputMessage.MAIN_DISPLAY_HEADER;
import static subway.view.constants.OutputMessage.PATH_DISPLAY_HEADER;
import static subway.view.constants.OutputMessage.STATION_DISPLAY_HEADER;
import static subway.view.constants.OutputMessage.STATION_READ_HEADER;
import static subway.view.constants.OutputMessage.SUBWAY_LINES_DISPLAY_HEADER;

import java.util.List;
import subway.dto.LineDTO;
import subway.dto.PathDTO;
import subway.dto.StationDTO;
import subway.view.constants.OutputMessage;
import subway.view.constants.menu.LineMenu;
import subway.view.constants.menu.MainMenu;
import subway.view.constants.menu.PathMenu;
import subway.view.constants.menu.StationMenu;

public class OutputView {

    public static void printInfoMessage(OutputMessage message) {
        ConsolePrinter.printInfo(message.getValue());
        ConsolePrinter.printBlankLine();
    }

    public static void printErrorMessage(String message) {
        ConsolePrinter.printError(message);
        ConsolePrinter.printBlankLine();
    }

    public static void printMainMenus() {
        ConsolePrinter.printHeader(MAIN_DISPLAY_HEADER.getValue());
        ConsolePrinter.printMenus(MainMenu.values());
        ConsolePrinter.printBlankLine();
    }

    public static void printStationMenus() {
        ConsolePrinter.printHeader(STATION_DISPLAY_HEADER.getValue());
        ConsolePrinter.printMenus(StationMenu.values());
        ConsolePrinter.printBlankLine();
    }

    public static void printLineMenus() {
        ConsolePrinter.printHeader(LINE_DISPLAY_HEADER.getValue());
        ConsolePrinter.printMenus(LineMenu.values());
        ConsolePrinter.printBlankLine();
    }

    public static void printPathMenus() {
        ConsolePrinter.printHeader(PATH_DISPLAY_HEADER.getValue());
        ConsolePrinter.printMenus(PathMenu.values());
        ConsolePrinter.printBlankLine();
    }

    public static void printStations(List<StationDTO> stations) {
        ConsolePrinter.printHeader(STATION_READ_HEADER.getValue());
        stations.forEach(station -> printInfo(station.getName()));
        ConsolePrinter.printBlankLine();
    }

    public static void printLines(List<LineDTO> lines) {
        ConsolePrinter.printHeader(LINE_READ_HEADER.getValue());
        lines.forEach(line -> printInfo(line.getName()));
        ConsolePrinter.printBlankLine();
    }

    public static void printSubwayLines(List<PathDTO> allPathsByLine) {
        ConsolePrinter.printHeader(SUBWAY_LINES_DISPLAY_HEADER.getValue());
        allPathsByLine.forEach(OutputView::printPathByLine);
        ConsolePrinter.printBlankLine();
    }

    private static void printPathByLine(PathDTO path) {
        ConsolePrinter.printInfo(path.getLineName());
        ConsolePrinter.printInfo(BORDER_LINE.getValue());
        path.getStations()
                .forEach(ConsolePrinter::printInfo);
        ConsolePrinter.printBlankLine();
    }
}
