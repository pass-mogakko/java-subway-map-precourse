package subway.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String MAIN_COMMAND_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String ADD_STATION_MESSAGE = "## 등록할 역 이름을 입력하세요.";

    public static String readMainCommand() {
        System.out.println();
        System.out.println(MAIN_COMMAND_MESSAGE);
        return Console.readLine();
    }

    public static String readStationName() {
        System.out.println();
        System.out.println(ADD_STATION_MESSAGE);
        return Console.readLine();
    }
}