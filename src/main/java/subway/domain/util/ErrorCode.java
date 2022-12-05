package subway.domain.util;

public enum ErrorCode {
    // 명령어 관련 오류
    INVALID_COMMAND("선택할 수 없는 기능입니다."),

    // 역 관련 오류
    INVALID_STATION_NAME("역 이름은 온전한 한글로만 이루어져야 하며, 3글자 이상이어야 합니다."),
    DUPLICATE_STATION_NAME("이미 존재하는 역 이름입니다."),
    STATION_NOT_FOUND("존재하지 않는 역입니다."),

    // 노선 관련 오류
    INVALID_LINE_NAME("노선 이름은 숫자나 온전한 한글로만만 이루어져야 하며, 3글자 이상이어야 합니다."),
    DUPLICATE_LINE_NAME("이미 존재하는 노선 이름입니다."),
    LINE_NOT_FOUND("존재하지 않는 노선입니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
