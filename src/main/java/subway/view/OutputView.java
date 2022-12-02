package subway.view;

import java.util.List;
import subway.constant.ErrorMessage;
import subway.constant.Message;
import subway.dto.SectionDto;

public class OutputView {

    public static void printErrorMessage(String message) {
        System.out.println();
        System.out.printf(ErrorMessage.ERROR_MESSAGE_FORM, message);
        System.out.println();
    }

    public static void printAllStations(List<String> allStations) {
        printTitleMessage(Message.STATION_LIST);
        allStations.forEach(OutputView::printInfoMessage);
    }

    public static void printTitleMessage(String message) {
        System.out.println();
        System.out.printf(Message.TITLE_MESSAGE_FORM, message);
        System.out.println();
    }

    private static void printInfoMessage(String message) {
        System.out.printf(Message.INFO_MESSAGE_FORM, message);
        System.out.println();
    }

    public static void printAllLines(List<String> allLines) {
        System.out.println();
        System.out.printf(Message.TITLE_MESSAGE_FORM, Message.LINE_LIST);
        System.out.println();
        allLines.forEach(OutputView::printLine);
    }

    private static void printLine(String lineName) {
        printInfoMessage(lineName);
    }

    public static void printRegisterSection() {
        System.out.println();
        printInfoMessage(Message.REGISTER_SECTION);
    }

    public static void printRegisterStation() {
        System.out.println();
        printInfoMessage(Message.REGISTER_STATION);
    }

    public static void printDeleteStation() {
        System.out.println();
        printInfoMessage(Message.DELETE_STATION);
    }

    public static void printRegisterLine() {
        System.out.println();
        printInfoMessage(Message.REGISTER_LINE);
    }

    public static void printDeleteLine() {
        System.out.println();
        printInfoMessage(Message.DELETE_LINE);
    }

    public static void printDeleteSection() {
        System.out.println();
        printInfoMessage(Message.DELETE_SECTION);
    }

    public static void printSubwayMap(List<SectionDto> sectionDtos) {
        printTitleMessage(Message.SUBWAY_MAP);
        sectionDtos.forEach(OutputView::printSubwayMap);
    }

    private static void printSubwayMap(SectionDto sectionDto) {
        String lineName = sectionDto.getLineName();
        List<String> stationNames = sectionDto.getStationName();

        printInfoMessage(lineName);
        printInfoMessage(Message.DIVISION_LINE);
        stationNames.forEach(OutputView::printInfoMessage);
        System.out.println();
    }
}
