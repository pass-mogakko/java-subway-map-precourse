package subway.constants;

public class ExceptionMessage {

    private static final String PREFIX = "[ERROR] ";

    public static final String CANT_CHOOSE = PREFIX + "선택할 수 없는 기능입니다.";

    public static final String ALREADY_INSERT_STATION = PREFIX + "이미 등록된 역 이름입니다.";
    public static final String ALREADY_INSERT_LINE = PREFIX + "이미 등록된 노선 이름입니다.";

    public static final String NOT_FOUND_STATION = PREFIX + "존재하지 않는 역입니다.";
    public static final String NOT_FOUND_LINE = PREFIX + "존재하지 않는 호선입니다.";

}
