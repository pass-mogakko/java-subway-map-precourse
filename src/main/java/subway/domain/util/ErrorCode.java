package subway.domain.util;

public enum ErrorCode {
    // 명령어 관련 오류
    INVALID_COMMAND("선택할 수 없는 기능입니다."),

    // 역 관련 오류
    INVALID_STATION_NAME("역 이름은 온전한 한글로만 이루어져야 하며, 3글자 이상이어야 합니다."),
    DUPLICATE_STATION_NAME("이미 존재하는 역 이름입니다. 메인 페이지로 돌아갑니다."),
    STATION_NOT_FOUND("존재하지 않는 역입니다. 메인 페이지로 돌아갑니다."),

    // 노선 관련 오류
    INVALID_LINE_NAME("노선 이름은 숫자나 온전한 한글로만만 이루어져야 하며, 3글자 이상이어야 합니다."),
    DUPLICATE_LINE_NAME("이미 존재하는 노선 이름입니다. 메인 페이지로 돌아갑니다."),
    LINE_NOT_FOUND("존재하지 않는 노선입니다. 메인 페이지로 돌아갑니다."),

    // 구간 관련 오류
    INVALID_ORDER_RANGE("구간은 1부터 시작하므로 1 이상의 숫자만 입력할 수 있습니다."),
    DUPLICATE_SECTION("이미 해당 노선에 존재하는 역입니다. 메인 페이지로 이동합니다."),
    SECTION_NOT_FOUND("존재하지 않는 구간입니다. 메인 페이지로 이동합니다."),
    TOO_SHORT_SECTION("노선에 포함된 역이 두 개 이하라 더 이상 구간을 삭제할 수 없습니다. 메인 페이지로 이동합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
