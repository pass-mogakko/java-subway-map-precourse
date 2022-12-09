package subway.view.input;

import subway.view.validator.Validator;

public class LineInputView implements InputView {

    private static final String INPUT_LINE_NAME = "## 등록할 노선 이름을 입력하세요.";
    private static final String INPUT_UP_STOP_NAME = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String INPUT_DOWN_STOP_NAME = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String INPUT_DELETE_LINE_NAME = "## 삭제할 노선 이름을 입력하세요.";

    public String readLineName() {
        System.out.println(INPUT_LINE_NAME);
        String lineName = scanner.nextLine();
        Validator.notExistentLine(lineName);
        return lineName;
    }

    public String readUpStopStationName() {
        System.out.println(INPUT_UP_STOP_NAME);
        String upStopStationName = scanner.nextLine();
        Validator.notExistentStation(upStopStationName);
        return upStopStationName;
    }

    public String readDownStopStationName() {
        System.out.println(INPUT_DOWN_STOP_NAME);
        String downStopStationName = scanner.nextLine();
        Validator.notExistentStation(downStopStationName);
        return downStopStationName;
    }

    public String readDeleteLineName() {
        System.out.println(INPUT_DELETE_LINE_NAME);
        String lineName = scanner.nextLine();
        Validator.existentLine(lineName);
        return lineName;
    }

}
