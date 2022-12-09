package subway.view.input;

import subway.view.validator.Validator;

public class StationInputView implements InputView {

    private static final String INPUT_STATION_NAME = "## 등록할 역 이름을 입력하세요.";
    private static final String INPUT_DELETE_STATION_NAME = "## 삭제할 역 이름을 입력하세요.";

    public String readNewStationName() {
        System.out.println(INPUT_STATION_NAME);
        String stationName = scanner.nextLine();
        Validator.notExistentStation(stationName);
        return stationName;
    }

    public String readDeleteStationName() {
        System.out.println(INPUT_DELETE_STATION_NAME);
        String stationName = scanner.nextLine();
        Validator.existentStation(stationName);
        return stationName;
    }
}
