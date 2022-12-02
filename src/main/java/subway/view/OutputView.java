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

    public static void printAllStation(List<String> allStation) {
        System.out.println();
        System.out.printf(Message.TITLE_MESSAGE_FORM, Message.STATION_LIST);
        System.out.println();
        allStation.forEach(OutputView::printStation);
    }

    private static void printStation(String stationName) {
        System.out.printf(Message.INFO_MESSAGE_FORM, stationName);
        System.out.println();
    }
}
