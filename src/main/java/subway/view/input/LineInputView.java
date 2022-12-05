package subway.view.input;

import java.util.Scanner;

public class LineInputView {

    static final Scanner scanner = new Scanner(System.in);

    private static final String INPUT_LINE_NAME = "## 등록할 노선 이름을 입력하세요.";

    private static final String INPUT_UP_STOP_NAME = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";

    private static final String INPUT_DOWN_STOP_NAME = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";

    private static final String INPUT_DELETE_LINE_NAME = "## 삭제할 노선 이름을 입력하세요.";

    public String readLineName() {
        System.out.println(INPUT_LINE_NAME);
        return scanner.nextLine();
    }

    public String readUpStopStationName() {
        System.out.println(INPUT_UP_STOP_NAME);
        return scanner.nextLine();
    }

    public String readDownStopStationName() {
        System.out.println(INPUT_DOWN_STOP_NAME);
        return scanner.nextLine();
    }

    public String readDeleteLineName() {
        System.out.println(INPUT_DELETE_LINE_NAME);
        return scanner.nextLine();
    }

}
