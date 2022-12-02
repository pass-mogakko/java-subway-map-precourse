package subway.domain.line;

import subway.constant.ErrorMessage;

public class LineRepository {

    private static final LineGroup lineGroup = new LineGroup();

    public static Line findLineByName(String name) {
        return lineGroup.findLineByName(name);
    }

    public static void validateIsUnregisterLine(String lineName) {
        if (lineGroup.isExistLine(lineName)) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_EXIST_LINE);
        }
    }
}
