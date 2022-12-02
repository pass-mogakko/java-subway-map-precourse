package subway.view;

import java.util.List;
import subway.constant.ErrorMessage;
import subway.constant.Message;

public class OutputView {

    public static void printErrorMessage(String message) {
        System.out.println();
        System.out.printf(ErrorMessage.ERROR_MESSAGE_FORM, message);
        System.out.println();
    }

    public static void printAllStations(List<String> allStations) {
        System.out.println();
        System.out.printf(Message.TITLE_MESSAGE_FORM, Message.STATION_LIST);
        System.out.println();
        allStations.forEach(OutputView::printStation);
    }

    private static void printStation(String stationName) {
        System.out.printf(Message.INFO_MESSAGE_FORM, stationName);
        System.out.println();
    }

    public static void printAllLines(List<String> allLines) {
        System.out.println();
        System.out.printf(Message.TITLE_MESSAGE_FORM, Message.LINE_LIST);
        System.out.println();
        allLines.forEach(OutputView::printLine);
    }

    private static void printLine(String lineName) {
        System.out.printf(Message.INFO_MESSAGE_FORM, lineName);
        System.out.println();
    }
}
