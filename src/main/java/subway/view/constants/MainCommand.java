package subway.view.constants;

import java.util.Arrays;

public enum MainCommand {

    STATION("1"),
    LINE("2"),
    PATH("3"),
    SUBWAY_LINES("4"),
    QUIT("Q")
    ;

    private final String key;

    MainCommand(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static MainCommand find(String key) {
        return Arrays.stream(values())
                .filter(value -> value.key.equals(key))
                .findFirst()
                // TODO 에러 메시지 상수화
                .orElseThrow(() -> {throw new IllegalArgumentException("잘못된 기능 번호를 선택했습니다.");});
    }
}
