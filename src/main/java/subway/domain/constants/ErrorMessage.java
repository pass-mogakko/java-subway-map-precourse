package subway.domain.constants;

public enum ErrorMessage {
    STATION_NAME_INVALID_LENGTH("역 이름은 최소 2글자 이상이어야 합니다."),
    LINE_NAME_INVALID_LENGTH("노선 이름은 최소 2글자 이상이어야 합니다."),

    STATION_EXISTING("이미 등록된 역 이름입니다."),
    STATION_NOT_FOUND("존재하지 않는 역 이름입니다."),
    STATION_IN_LINE("노선에 등록된 역은 삭제할 수 없습니다."),

    LINE_EXISTING("이미 등록된 노선 이름입니다."),
    LINE_NOT_FOUND("존재하지 않는 노선 이름입니다."),

    UP_FINAL_STATION_NOT_FOUND("상행 종점역 등록 불가: 존재하지 않는 역 이름입니다."),
    DOWN_FINAL_STATION_NOT_FOUND("하행 종점역 등록 불가: 존재하지 않는 역 이름입니다."),
    PATH_BY_LINE_NOT_FOUND("해당 노선 이름에 대한 노선 경로 정보가 존재하지 않습니다."),

    PATH_INVALID_INDEX("노선 사이에 빈 구간을 둘 수 없습니다."),
    PATH_DUPLICATED_STATION("이미 해당 노선에 포함된 역입니다."),
    PATH_INVALID_SIZE("해당 노선의 역이 2개이므로 더 이상 삭제할 수 없습니다."),
    PATH_INVALID_STATION("해당 노선에 포함되지 않은 역입니다.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
