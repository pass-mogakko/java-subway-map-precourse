package subway.domain.line;

import subway.constant.Constant;
import subway.constant.ErrorMessage;

public class Line {

    private final String name;

    public Line(String name) {
        validate(name);
        this.name = name;
    }

    private static void validate(String name) {
        if (name.length() < Constant.LINE_NAME_SIZE_MIN) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_LINE_NAME_SIZE);
        }
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }
}
