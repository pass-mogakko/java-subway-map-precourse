package subway.domain.util;

public enum InfoCode {
    // 역 관련 안내 메시지
    STATION_ADDITION_COMPLETE("지하철 역이 등록되었습니다."),
    STATION_DELETION_COMPLETE("지하철 역이 삭제되었습니다."),

    // 노선 관련 안내 메시지
    LINE_ADDITION_COMPLETE("지하철 노선이 등록되었습니다."),
    LINE_DELETION_COMPLETE("지하철 노선이 삭제되었습니다."),

    // 구간 관련 안내 메시지
    SECTION_ADDITION_COMPLETE("지하철 구간이 등록되었습니다."),
    SECTION_DELETION_COMPLETE("지하철 구간이 삭제되었습니다.");

    private final String message;

    InfoCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
