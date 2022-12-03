package subway.view;

import java.util.Arrays;
import java.util.Scanner;
import subway.constant.Message;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String requestMainScreenSelection() {
        printSelectionTitle(Message.MAIN_SCREEN);
        Arrays.stream(MainScreenSelection.values())
                .map(MainScreenSelection::toKorean)
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
                .map(StationManageSelection::toKorean)
                .forEach(System.out::println);
        printSelectFunction();
        String stationManageSelection = scanner.nextLine();
        StationManageSelection.validate(stationManageSelection);
        return stationManageSelection;
    }

    public static String requestRegisterStation() {
        printSelectionTitle(Message.REQUEST_REGISTER_STATION);
        return scanner.nextLine();
    }

    public static String requestDeleteStation() {
        printSelectionTitle(Message.REQUEST_DELETE_STATION);
        return scanner.nextLine();
    }

    public static String requestLineManageSelection() {
        printSelectionTitle(Message.LINE_MANAGE_SCREEN);
        Arrays.stream(LineManageSelection.values())
                .map(LineManageSelection::toKorean)
                .forEach(System.out::println);
        printSelectFunction();
        String lineManageSelection = scanner.nextLine();
        LineManageSelection.validate(lineManageSelection);
        return lineManageSelection;
    }

    public static String requestRegisterLine() {
        printSelectionTitle(Message.REQUEST_REGISTER_LINE);
        return scanner.nextLine();
    }

    public static String requestRegisterLineFirstStation() {
        printSelectionTitle(Message.REQUEST_LINE_FIRST_STATION);
        return scanner.nextLine();
    }

    public static String requestRegisterLineLastStation() {
        printSelectionTitle(Message.REQUEST_LINE_LAST_STATION);
        return scanner.nextLine();
    }

    public static String requestDeleteLine() {
        printSelectionTitle(Message.REQUEST_DELETE_LINE);
        return scanner.nextLine();
    }

    public static String requestSectionManageSelection() {
        printSelectionTitle(Message.SECTION_MANAGE_SCREEN);
        Arrays.stream(SectionManageSelection.values())
                .map(SectionManageSelection::toKorean)
                .forEach(System.out::println);
        printSelectFunction();
        String sectionManageSelection = scanner.nextLine();
        SectionManageSelection.validate(sectionManageSelection);
        return sectionManageSelection;
    }

    public static String requestLineOfRegisterSection() {
        printSelectionTitle(Message.REQUEST_LINE_OF_REGISTER_SECTION);
        return scanner.nextLine();
    }

    public static String requestStationOfRegisterSection() {
        printSelectionTitle(Message.REQUEST_STATION_OF_REGISTER_SECTION);
        return scanner.nextLine();
    }

    public static int requestOrderOfRegisterSection() {
        printSelectionTitle(Message.REQUEST_ORDER_OF_REGISTER_SECTION);
        int order = scanner.nextInt();
        scanner.nextLine();
        return order;
    }

    public static String requestLineOfDeleteSection() {
        printSelectionTitle(Message.REQUEST_LINE_OF_DELETE_SECTION);
        return scanner.nextLine();
    }

    public static String requestStationOfDeleteSection() {
        printSelectionTitle(Message.REQUEST_STATION_OF_DELETE_SECTION);
        return scanner.nextLine();
    }
}
