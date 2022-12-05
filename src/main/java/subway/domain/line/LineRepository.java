package subway.domain.line;

import java.util.List;

public class LineRepository {

    private static final LineGroup lineGroup = new LineGroup();

    public static Line findLineByName(String name) {
        return lineGroup.findLineByName(name);
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
