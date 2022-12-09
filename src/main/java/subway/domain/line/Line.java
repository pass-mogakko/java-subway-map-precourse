package subway.domain.line;

import static subway.domain.constants.ErrorMessage.LINE_NAME_INVALID_LENGTH;
import static subway.domain.constants.SubwayRule.NAME_MINIMUM_LENGTH;

public class Line {
    private final String name;

    public Line(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() < NAME_MINIMUM_LENGTH.getValue()) {
            throw new IllegalArgumentException(LINE_NAME_INVALID_LENGTH.getValue());
        }
    }

    public String getName() {
        return name;
    }
}
