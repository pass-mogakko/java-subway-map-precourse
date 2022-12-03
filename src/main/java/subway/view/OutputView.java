package subway.view;

import static subway.view.constants.Format.HEADER;
import static subway.view.constants.Format.INFO;
import static subway.view.constants.Format.MENU;
import static subway.view.constants.OutputMessage.LINE_DISPLAY_HEADER;
import static subway.view.constants.OutputMessage.LINE_READ_HEADER;
import static subway.view.constants.OutputMessage.MAIN_DISPLAY_HEADER;
import static subway.view.constants.OutputMessage.PATH_DISPLAY_HEADER;
import static subway.view.constants.OutputMessage.STATION_DISPLAY_HEADER;
import static subway.view.constants.OutputMessage.STATION_READ_HEADER;
import static subway.view.constants.SubDisplay.BACK;
import static subway.view.constants.SubDisplay.LINE_CREATE;
import static subway.view.constants.SubDisplay.LINE_DELETE;
import static subway.view.constants.SubDisplay.LINE_READ;
import static subway.view.constants.SubDisplay.PATH_CREATE;
import static subway.view.constants.SubDisplay.PATH_DELETE;
import static subway.view.constants.SubDisplay.STATION_CREATE;
import static subway.view.constants.SubDisplay.STATION_DELETE;
import static subway.view.constants.SubDisplay.STATION_READ;

import java.util.Arrays;
import java.util.List;
import subway.dto.LineDTO;
import subway.dto.StationDTO;
import subway.view.constants.MainDisplay;
import subway.view.constants.OutputMessage;

public class OutputView {

    public static void printInfoMessage(OutputMessage message) {
        ConsolePrinter.printFormattedLine(INFO, message.getValue());
        ConsolePrinter.printBlankLine();
    }

    public static void printMain() {
        ConsolePrinter.printFormattedLine(HEADER, MAIN_DISPLAY_HEADER.getValue());
        Arrays.stream(MainDisplay.values())
                        .forEach(value -> ConsolePrinter.printFormattedLine(MENU, value.getCommandKey(), value.getMenu()));
        ConsolePrinter.printBlankLine();
    }

    // TODO SubDisplay에 find 기능 만들어서 코드 단순화
    public static void printStationDisplay() {
        ConsolePrinter.printFormattedLine(HEADER, STATION_DISPLAY_HEADER.getValue());
        ConsolePrinter.printFormattedLine(MENU, STATION_CREATE.getCommandKey(), STATION_CREATE.getMenu());
        ConsolePrinter.printFormattedLine(MENU, STATION_DELETE.getCommandKey(), STATION_DELETE.getMenu());
        ConsolePrinter.printFormattedLine(MENU, STATION_READ.getCommandKey(), STATION_READ.getMenu());
        ConsolePrinter.printFormattedLine(MENU, BACK.getCommandKey(), BACK.getMenu());
        ConsolePrinter.printBlankLine();
    }

    public static void printLineDisplay() {
        ConsolePrinter.printFormattedLine(HEADER, LINE_DISPLAY_HEADER.getValue());
        ConsolePrinter.printFormattedLine(MENU, LINE_CREATE.getCommandKey(), LINE_CREATE.getMenu());
        ConsolePrinter.printFormattedLine(MENU, LINE_DELETE.getCommandKey(), LINE_DELETE.getMenu());
        ConsolePrinter.printFormattedLine(MENU, LINE_READ.getCommandKey(), LINE_READ.getMenu());
        ConsolePrinter.printFormattedLine(MENU, BACK.getCommandKey(), BACK.getMenu());
        ConsolePrinter.printBlankLine();
    }

    public static void printPathDisplay() {
        ConsolePrinter.printFormattedLine(HEADER, PATH_DISPLAY_HEADER.getValue());
        ConsolePrinter.printFormattedLine(MENU, PATH_CREATE.getCommandKey(), PATH_CREATE.getMenu());
        ConsolePrinter.printFormattedLine(MENU, PATH_DELETE.getCommandKey(), PATH_DELETE.getMenu());
        ConsolePrinter.printFormattedLine(MENU, BACK.getCommandKey(), BACK.getMenu());
        ConsolePrinter.printBlankLine();
    }

    public static void printStations(List<StationDTO> stations) {
        ConsolePrinter.printFormattedLine(HEADER, STATION_READ_HEADER.getValue());
        stations.forEach(station -> ConsolePrinter.printFormattedLine(INFO, station.getName()));
        ConsolePrinter.printBlankLine();
    }

    public static void printLines(List<LineDTO> lines) {
        ConsolePrinter.printFormattedLine(HEADER, LINE_READ_HEADER.getValue());
        lines.forEach(line -> ConsolePrinter.printFormattedLine(INFO, line.getName()));
        ConsolePrinter.printBlankLine();
    }

}
