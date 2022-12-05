package subway.view.constants;

public enum OutputMessage {
    MAIN_DISPLAY_HEADER("메인 화면"),
    STATION_DISPLAY_HEADER("역 관리 화면"),
    LINE_DISPLAY_HEADER("노선 관리 화면"),
    PATH_DISPLAY_HEADER("구간 관리 화면"),
    SUBWAY_LINES_DISPLAY_HEADER("지하철 노선도"),

    STATION_READ_HEADER("역 목록"),
    LINE_READ_HEADER("노선 목록"),

    STATION_CREATE_INFO("지하철 역이 등록되었습니다."),
    STATION_DELETE_INFO("지하철 역이 삭제되었습니다."),

    LINE_CREATE_INFO("지하철 노선이 등록되었습니다."),
    LINE_DELETE_INFO("지하철 노선이 삭제되었습니다."),

    PATH_CREATE_INFO("구간이 등록되었습니다."),
    PATH_DELETE_INFO("구간이 삭제되었습니다."),

    BORDER_LINE("---");

    private final String value;

    OutputMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
