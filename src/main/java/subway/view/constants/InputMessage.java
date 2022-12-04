package subway.view.constants;

public enum InputMessage {

    COMMAND_HEADER("원하는 기능을 선택하세요."),

    STATION_CREATE_NAME_HEADER("등록할 역 이름을 입력하세요."),
    STATION_DELETE_NAME_HEADER("삭제할 역 이름을 입력하세요."),

    LINE_CREATE_NAME_HEADER("등록할 노선 이름을 입력하세요."),
    LINE_CREATE_UP_FINAL_NAME_HEADER("등록할 노선의 상행 종점역 이름을 입력하세요."),
    LINE_CREATE_DOWN_FINAL_NAME_HEADER("등록할 노선의 하행 종점역 이름을 입력하세요."),
    LINE_DELETE_HEADER("삭제할 노선 이름을 입력하세요."),

    PATH_CREATE_LINE_NAME_HEADER("노선을 입력하세요."),
    PATH_CREATE_STATION_NAME_HEADER("역 이름을 입력하세요."),
    PATH_CREATE_INDEX_HEADER("순서를 입력하세요."),
    PATH_DELETE_LINE_NAME_HEADER("삭제할 구간의 노선을 입력하세요."),
    PATH_DELETE_STATION_NAME_HEADER("삭제할 구간의 역을 입력하세요."),
    ;

    private final String value;

    InputMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
