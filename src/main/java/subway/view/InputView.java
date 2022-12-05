package subway.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String COMMAND_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String ADD_STATION_MESSAGE = "## 등록할 역 이름을 입력하세요.";
    private static final String DELETE_STATION_MESSAGE = "## 삭제할 역 이름을 입력하세요.";
    private static final String ADD_LINE_MESSAGE = "## 등록할 노선 이름을 입력하세요.";

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
}