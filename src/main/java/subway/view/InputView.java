package subway.view;

import java.util.Arrays;
import java.util.Scanner;
import subway.constant.Message;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String requestMainScreenSelection() {
        printTitleMessage(Message.MAIN_SCREEN);
        Arrays.stream(MainScreenSelection.values())
                .map(MainScreenSelection::toKorean)
                .forEach(System.out::println);
        printSelectFunction();
        String mainScreenSelection = scanner.nextLine();
        MainScreenSelection.validate(mainScreenSelection);
        return mainScreenSelection;
    }

    private static void printTitleMessage(String selectionTitle) {
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
        printTitleMessage(Message.STATION_MANAGE_SCREEN);
        Arrays.stream(StationManageSelection.values())
                .map(StationManageSelection::toKorean)
                .forEach(System.out::println);
        printSelectFunction();
        String stationManageSelection = scanner.nextLine();
        StationManageSelection.validate(stationManageSelection);
        return stationManageSelection;
    }

    public static String requestRegisterStation() {
        printTitleMessage(Message.REQUEST_REGISTER_STATION);
        return scanner.nextLine();
    }

    public static String requestDeleteStation() {
        printTitleMessage(Message.REQUEST_DELETE_STATION);
        return scanner.nextLine();
    }

    public static String requestLineManageSelection() {
        printTitleMessage(Message.LINE_MANAGE_SCREEN);
        Arrays.stream(LineManageSelection.values())
                .map(LineManageSelection::toKorean)
                .forEach(System.out::println);
        printSelectFunction();
        String lineManageSelection = scanner.nextLine();
        LineManageSelection.validate(lineManageSelection);
        return lineManageSelection;
    }

    public static String requestRegisterLine() {
        printTitleMessage(Message.REQUEST_REGISTER_LINE);
        return scanner.nextLine();
    }

    public static String requestRegisterLineFirstStation() {
        printTitleMessage(Message.REQUEST_LINE_FIRST_STATION);
        return scanner.nextLine();
    }

    public static String requestRegisterLineLastStation() {
        printTitleMessage(Message.REQUEST_LINE_LAST_STATION);
        return scanner.nextLine();
    }

    public static String requestDeleteLine() {
        printTitleMessage(Message.REQUEST_DELETE_LINE);
        return scanner.nextLine();
    }

    public static String requestSectionManageSelection() {
        printTitleMessage(Message.SECTION_MANAGE_SCREEN);
        Arrays.stream(SectionManageSelection.values())
                .map(SectionManageSelection::toKorean)
                .forEach(System.out::println);
        printSelectFunction();
        String sectionManageSelection = scanner.nextLine();
        SectionManageSelection.validate(sectionManageSelection);
        return sectionManageSelection;
    }

    public static String requestLineOfRegisterSection() {
        printTitleMessage(Message.REQUEST_LINE_OF_REGISTER_SECTION);
        return scanner.nextLine();
    }

    public static String requestStationOfRegisterSection() {
        printTitleMessage(Message.REQUEST_STATION_OF_REGISTER_SECTION);
        return scanner.nextLine();
    }

    public static int requestOrderOfRegisterSection() {
        printTitleMessage(Message.REQUEST_ORDER_OF_REGISTER_SECTION);
        int order = scanner.nextInt();
        scanner.nextLine();
        return order;
    }

    public static String requestLineOfDeleteSection() {
        printTitleMessage(Message.REQUEST_LINE_OF_DELETE_SECTION);
        return scanner.nextLine();
    }

    public static String requestStationOfDeleteSection() {
        printTitleMessage(Message.REQUEST_STATION_OF_DELETE_SECTION);
        return scanner.nextLine();
    }
}
