package subway.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String MAIN_COMMAND_MESSAGE = "## 원하는 기능을 선택하세요.";

    public static String readMainCommand() {
        System.out.println();
        System.out.println(MAIN_COMMAND_MESSAGE);
        return Console.readLine();
    }
}
