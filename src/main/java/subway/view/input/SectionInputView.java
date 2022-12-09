package subway.view.input;

import subway.view.validator.Validator;

public class SectionInputView implements InputView {

    private static final String INPUT_INSERT_SECTION_LINE = "## 노선을 입력하세요.";
    private static final String INPUT_INSERT_SECTION_STATION = "## 역이름을 입력하세요.";
    private static final String INPUT_INSERT_SECTION_INDEX = "## 순서를 입력하세요.";

    private static final String INPUT_DELETE_SECTION_LINE = "## 삭제할 구간의 노선을 입력하세요.";
    private static final String INPUT_DELETE_SECTION_STATION = "## 삭제할 구간의 역을 입력하세요.";

    public String readLineName() {
        System.out.println(INPUT_INSERT_SECTION_LINE);
        String lineName = scanner.nextLine();
        Validator.existentLine(lineName);
        return lineName;
    }

    public String readStationName() {
        System.out.println(INPUT_INSERT_SECTION_STATION);
        String stationName = scanner.nextLine();
        Validator.existentStation(stationName);
        return stationName;
    }

    public int readIndex() {
        System.out.println(INPUT_INSERT_SECTION_INDEX);
        // validate
        return Integer.parseInt(scanner.nextLine());
    }

    public String readDeleteLineName() {
        System.out.println(INPUT_DELETE_SECTION_LINE);
        return scanner.nextLine();

    }

    public String readDeleteStationName() {
        System.out.println(INPUT_DELETE_SECTION_STATION);
        return scanner.nextLine();
    }

}
