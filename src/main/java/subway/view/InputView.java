package subway.view;

import java.util.Arrays;
import java.util.Scanner;
import subway.constant.Message;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String requestMainScreenSelection() {
        System.out.println();
        System.out.printf(Message.IMPORTANT_MESSAGE_FORM, Message.MAIN_SCREEN);
        System.out.println();
        Arrays.stream(MainScreenSelection.values())
                .forEach(InputView::printMainScreenSelectionSentence);
        System.out.println();
        System.out.printf(Message.IMPORTANT_MESSAGE_FORM, Message.SELECT_FUNCTION);
        System.out.println();
        String selection = scanner.nextLine();
        MainScreenSelection.validate(selection);
        return selection;
    }

    private static void printMainScreenSelectionSentence(MainScreenSelection mainScreenSelection) {
        String selection = mainScreenSelection.getSelection();
        String content = mainScreenSelection.getContent();
        String selectionSentence = String.format(Message.SELECTION_MESSAGE_FROM, selection, content);
        System.out.println(selectionSentence);
    }

    public static String requestStationManageSelection() {
        System.out.println();
        System.out.printf(Message.IMPORTANT_MESSAGE_FORM, Message.STATION_MANAGE_SCREEN);
        System.out.println();
        Arrays.stream(StationManageSelection.values())
                .forEach(InputView::printStationManageSelectionSentence);
        System.out.println();
        System.out.printf(Message.IMPORTANT_MESSAGE_FORM, Message.SELECT_FUNCTION);
        System.out.println();
        return null;
    }

    private static void printStationManageSelectionSentence(StationManageSelection stationManageSelection) {
        String selection = stationManageSelection.getSelection();
        String content = stationManageSelection.getContent();
        String selectionSentence = String.format(Message.SELECTION_MESSAGE_FROM, selection, content);
        System.out.println(selectionSentence);
    }
}
