package subway.view;

import java.util.Arrays;
import java.util.Scanner;
import subway.constant.Constant;
import subway.constant.ErrorMessage;
import subway.constant.Message;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String requestMainScreenSelection() {
        printSelectionTitle(Message.MAIN_SCREEN);
        Arrays.stream(MainScreenSelection.values())
                .forEach(System.out::println);
        printSelectFunction();
        String mainScreenSelection = scanner.nextLine();
        MainScreenSelection.validate(mainScreenSelection);
        return mainScreenSelection;
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

    public static String requestStationManageSelection() {
        printSelectionTitle(Message.STATION_MANAGE_SCREEN);
        Arrays.stream(StationManageSelection.values())
                .forEach(System.out::println);
        printSelectFunction();
        String stationManageSelection = scanner.nextLine();
        StationManageSelection.validate(stationManageSelection);
        return stationManageSelection;
    }

    public static String requestRegisterStation() {
        printSelectionTitle(Message.REQUEST_REGISTER_STATION);
        String registerStation = scanner.nextLine();
        validateRegisterStation(registerStation);
        return registerStation;
    }

    private static void validateRegisterStation(String registerStation) {
        if (registerStation.length() < Constant.STATION_NAME_SIZE_MIN) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_STATION_NAME_SIZE);
        }
    }

    public static String requestDeleteStation() {
        printSelectionTitle(Message.REQUEST_DELETE_STATION);
        String deleteStation = scanner.nextLine();
        return deleteStation;
    }

    public static String requestLineManageSelection() {
        printSelectionTitle(Message.LINE_MANAGE_SCREEN);
        Arrays.stream(LineManageSelection.values())
                .forEach(System.out::println);
        printSelectFunction();
        String lineManageSelection = scanner.nextLine();
        LineManageSelection.validate(lineManageSelection);
        return lineManageSelection;
    }

    public static String requestRegisterLine() {
        printSelectionTitle(Message.REQUEST_REGISTER_LINE);
        String registerLine = scanner.nextLine();
        validateRegisterLine(registerLine);
        return registerLine;
    }

    private static void validateRegisterLine(String registerLine) {
        if (registerLine.length() < Constant.LINE_NAME_SIZE_MIN) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_LINE_NAME_SIZE);
        }
    }

    public static String requestRegisterLineFirstStation() {
        printSelectionTitle(Message.REQUEST_LINE_FIRST_STATION);
        String firstStation = scanner.nextLine();
        return firstStation;
    }

    public static String requestRegisterLineLastStation(String firstStation) {
        printSelectionTitle(Message.REQUEST_LINE_LAST_STATION);
        String lastStation = scanner.nextLine();
        if (firstStation.equals(lastStation)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_REGISTER_LINE_LAST_STATION);
        }
        return lastStation;
    }

    public static String requestDeleteLine() {
        printSelectionTitle(Message.REQUEST_DELETE_LINE);
        String deleteLine = scanner.nextLine();
        return deleteLine;
    }

    public static String requestSectionManageSelection() {
        printSelectionTitle(Message.SECTION_MANAGE_SCREEN);
        Arrays.stream(SectionManageSelection.values())
                .forEach(System.out::println);
        printSelectFunction();
        String sectionManageSelection = scanner.nextLine();
        SectionManageSelection.validate(sectionManageSelection);
        return sectionManageSelection;
    }

    public static String requestLine() {
        printSelectionTitle(Message.REQUEST_LINE);
        String line = scanner.nextLine();
        return line;
    }

    public static String requestStation() {
        printSelectionTitle(Message.REQUEST_STATION);
        String line = scanner.nextLine();
        return line;
    }

    public static int requestOrder() {
        printSelectionTitle(Message.REQUEST_ORDER);
        int order = scanner.nextInt();
        return order;
    }
}
