package subway.message;

public class ErrorMessage {
    private static final String ERROR = "[ERROR] ";
    public static final String NOT_EXIST_FUNCTION = ERROR + "선택할 수 없는 기능입니다.";
    public static final String MINIMUM_NAME_LENGTH = ERROR + "지하철 역 이름은 두글자 이상이어야 합니다.";
    public static final String ALREADY_EXISTING_STATION = ERROR + "이미 등록된 역 이름입니다.";
    public static final String NOT_EXIST_STATION = ERROR + "존재하지 않는 역입니다.";

}
