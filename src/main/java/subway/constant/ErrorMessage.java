package subway.constant;

public class ErrorMessage {

    public static final String ERROR_MESSAGE_FORM = "[ERROR] %s";
    public static final String NOT_EXIST_LINE = "존재하지 않는 노선입니다.";
    public static final String NOT_EXIST_STATION = "존재하지 않는 역입니다.";
    public static final String NOT_EXIST_SELECTION = "선택할 수 없는 기능입니다.";
    public static final String WRONG_STATION_NAME_SIZE = "역 이름은 2글자 이상이어야 합니다.";
    public static final String WRONG_LINE_NAME_SIZE = "노선 이름은 2글자 이상이어야 합니다.";
    public static final String ALREADY_EXIST_STATION = "이미 등록된 역 이름입니다. ";
    public static final String ALREADY_EXIST_LINE = "이미 등록된 노선 이름입니다. ";
    public static final String WRONG_REGISTER_LINE_LAST_STATION = "상행 종점역과 하행 종점역은 달라야 합니다.";
    public static final String WRONG_SECTION_ORDER = "불가능한 구간 순서 입니다.";
    public static final String ALREADY_EXIST_SECTION = "해당 역은 이미 구간에 포함되어 있습니다.";
    public static final String NOT_EXIST_SECTION = "해당 역은 해당 노선의 구간에 포함되어 있지 않습니다.";
    public static final String WRONG_SECTION_SIZE = "노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없습니다.";
}
