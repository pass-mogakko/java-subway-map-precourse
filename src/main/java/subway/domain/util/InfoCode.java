package subway.domain.util;

public enum InfoCode {
    // 역 관련 안내 메시지
    ADD_STATION_COMPLETE("지하철역이 등록되었습니다."),;

    private final String message;

    InfoCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
