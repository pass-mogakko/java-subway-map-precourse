package subway.message;

public class ErrorMessage {
    private static final String ERROR = "[ERROR] ";
    public static final String NOT_EXIST_FUNCTION = ERROR + "선택할 수 없는 기능입니다.";

    // Station
    public static final String MINIMUM_STATION_NAME_LENGTH = ERROR + "지하철 역 이름은 두글자 이상이어야 합니다.";
    public static final String ALREADY_EXISTING_STATION = ERROR + "이미 등록된 역 이름입니다.";
    public static final String NOT_EXIST_STATION = ERROR + "존재하지 않는 역입니다.";
    public static final String REGISTERED_STATION_ON_LINE = ERROR + "노선에 등록된 역은 삭제할 수 없습니다.";

    // Line
    public static final String ALREADY_EXIST_LINE = ERROR + "이미 등록된 노선 이름입니다.";
    public static final String MINIMUM_LINE_NAME_LENGTH = ERROR + "노선 이름은 두글자 이상이어야 합니다.";
    public static final String NOT_EXIST_LINE = ERROR + "존재하지 않는 노선입니다.";

    // Section
    public static final String ORDER_NOT_NUMERIC = ERROR + "숫자만 입력할 수 있습니다.";
    public static final String ORDER_LESS_THAN_MINIMUM = ERROR + "순서는 1이상이어야 합니다.";
    public static final String ORDER_OVER_THAN_SECTION = ERROR + "순서는 노선의 구간 수 보다 작아야합니다.";
    public static final String ALREADY_EXISTING_SECTION_STATION = ERROR + "이미 노선에 등록된 역 입니다.";
    public static final String NOT_EXIST_SECTION_STATION = ERROR + "해당 노선에 존재하지 않는 역 입니다.";
    public static final String MINIMUM_SECTION_SIZE = ERROR + "노선의 길이가 2이하 이므로 삭제할 수 없습니다.";
}
