package subway.view;

import java.util.Arrays;
import java.util.Scanner;
import subway.constant.Message;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String requestMainScreenSelection() {
        printSelectionTitle(Message.MAIN_SCREEN);
        Arrays.stream(MainScreenSelection.values())
                .forEach(System.out::println);
        printSelectFunction();
        String selection = scanner.nextLine();
        MainScreenSelection.validate(selection);
        return selection;
    }

    public static String requestStationManageSelection() {
        printSelectionTitle(Message.STATION_MANAGE_SCREEN);
        Arrays.stream(StationManageSelection.values())
                .forEach(System.out::println);
        printSelectFunction();
        String selection = scanner.nextLine();
        StationManageSelection.validate(selection);
        return selection;
    }

    private static void printSelectionTitle(String selectionTitle) {
        System.out.println();
        System.out.printf(Message.TITLE_MESSAGE_FORM, selectionTitle);
        System.out.println();
    }

    private static void printSelectFunction() {
        System.out.println();
        System.out.printf(Message.TITLE_MESSAGE_FORM, Message.SELECT_FUNCTION);
        System.out.println();
    }

}
