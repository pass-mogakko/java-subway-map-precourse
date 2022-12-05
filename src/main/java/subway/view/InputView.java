package subway.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    // 메인 페이지 관련 상수
    private static final String COMMAND_MESSAGE = "## 원하는 기능을 선택하세요.";
    // 역 관련 상수
    private static final String ADD_STATION_MESSAGE = "## 등록할 역 이름을 입력하세요.";
    private static final String DELETE_STATION_MESSAGE = "## 삭제할 역 이름을 입력하세요.";
    // 노선 관련 상수
    private static final String DELETE_LINE_MESSAGE = "## 삭제할 노선 이름을 입력하세요.";
    private static final String ADD_LINE_MESSAGE = "## 등록할 노선 이름을 입력하세요.";
    private static final String ADD_UP_FINAL_STATION_MESSAGE = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String ADD_DOWN_FINAL_STATION_MESSAGE = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    // 구간 관련 상수
    private static final String READ_LINE_MESSAGE = "## 노선을 입력하세요.";
    private static final String READ_STATION_MESSAGE = "## 역 이름을 입력하세요.";
    private static final String READ_ORDER_MESSAGE = "## 순서를 입력하세요.";

    private static final InputValidator inputValidator = new InputValidator();

    public static String readMainCommand() {
        System.out.println();
        System.out.println(COMMAND_MESSAGE);

        String input = Console.readLine();
        inputValidator.validateMainCommand(input);
        return input;
    }

    public static String readDetailCommand() {
        System.out.println();
        System.out.println(COMMAND_MESSAGE);

        String input = Console.readLine();
        inputValidator.validateDetailCommand(input);
        return input;
    }

    public static String readStationNameToAdd() {
        System.out.println();
        System.out.println(ADD_STATION_MESSAGE);

        String input = Console.readLine();
        inputValidator.validateStationName(input);
        return input;
    }

    public static String readStationNameToDelete() {
        System.out.println();
        System.out.println(DELETE_STATION_MESSAGE);

        String input = Console.readLine();
        inputValidator.validateStationName(input);
        return input;
    }

    public static String readLineNameToAdd() {
        System.out.println();
        System.out.println(ADD_LINE_MESSAGE);

        String input = Console.readLine();
        inputValidator.validateLineName(input);
        return input;
    }

    public static String readUpFinalStation() {
        System.out.println();
        System.out.println(ADD_UP_FINAL_STATION_MESSAGE);

        String input = Console.readLine();
        inputValidator.validateStationName(input);
        return input;
    }

    public static String readDownFinalStation() {
        System.out.println();
        System.out.println(ADD_DOWN_FINAL_STATION_MESSAGE);

        String input = Console.readLine();
        return inputValidator.validateStationName(input);
    }

    public static String readLineNameToDelete() {
        System.out.println();
        System.out.println(DELETE_LINE_MESSAGE);

        String input = Console.readLine();
        return inputValidator.validateLineName(input);
    }

    public static String readSectionCommand() {
        System.out.println();
        System.out.println(COMMAND_MESSAGE);

        String input = Console.readLine();
        inputValidator.validateSectionCommand(input);
        return input;
    }

    public static String readLineName() {
        System.out.println();
        System.out.println(READ_LINE_MESSAGE);

        String input = Console.readLine();
        return inputValidator.validateLineName(input);
    }

    public static String readStationName() {
        System.out.println();
        System.out.println(READ_STATION_MESSAGE);

        String input = Console.readLine();
        return inputValidator.validateStationName(input);
    }

    public static int readSectionOrder() {
        System.out.println();
        System.out.println(READ_ORDER_MESSAGE);

        String input = Console.readLine();
        return inputValidator.validateSectionOrder(input);
    }
}