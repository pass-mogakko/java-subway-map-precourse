package subway.domain.line;

import java.util.List;
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

    public static void addLine(String registerLine) {
        lineGroup.addLineByName(registerLine);
    }

    public static void deleteLineByName(String lineName) {
        lineGroup.deleteLineByName(lineName);
    }

    public static List<String> findAllLineNames() {
        return lineGroup.findAllLineNames();
    }
}
