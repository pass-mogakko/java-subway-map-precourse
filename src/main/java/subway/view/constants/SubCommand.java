package subway.view.constants;

import java.util.Arrays;

public enum SubCommand {

    CREATE("1"),
    DELETE("2"),
    READ("3"),
    BACK("B")
    ;

    private final String key;

    SubCommand(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static SubCommand find(String key) {
        return Arrays.stream(values())
                .filter(value -> value.key.equals(key))
                .findFirst()
                // TODO 에러 메시지 상수화
                .orElseThrow(() -> {throw new IllegalArgumentException("잘못된 기능 번호를 선택했습니다.");});
    }
}
