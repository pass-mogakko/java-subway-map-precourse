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
        allStations.forEach(OutputView::printInfoMessage);
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
}
