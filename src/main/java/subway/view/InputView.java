package subway.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import subway.constant.Message;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String requestMainScreenSelection() {
        printSelectionTitle(Message.MAIN_SCREEN);
        Arrays.stream(MainScreenSelection.values())
                .forEach(System.out::println);
        printSelectFunction();
        String selection = scanner.nextLine();
        boolean isThrowError = isThrowError(MainScreenSelection::validate, selection);
        if (isThrowError) {
            return requestMainScreenSelection();
        }
        return selection;
    }

    public static String requestStationManageSelection() {
        printSelectionTitle(Message.STATION_MANAGE_SCREEN);
        Arrays.stream(StationManageSelection.values())
                .forEach(System.out::println);
        printSelectFunction();
        String selection = scanner.nextLine();
        boolean isThrowError = isThrowError(StationManageSelection::validate, selection);
        if (isThrowError) {
            return requestStationManageSelection();
        }
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

    public static String requestRegisterStation() {
        printSelectionTitle(Message.REQUEST_REGISTER_STATION);
        String registerStation = scanner.nextLine();
        return registerStation;
    }

    private static boolean isThrowError(Consumer<String> validateFunction, String input) {
        try {
            validateFunction.accept(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return true;
        }
        return false;
    }
}
