package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.Constants;



public class LineRepository {
    private static final String INVALID_LINE = Constants.ERROR_PREFIX + "존재하지 않는 노선입니다.";
    private static final String DUPLICATED_LINE = Constants.ERROR_PREFIX + "중복된 노선입니다.";
    private static final List<Line> lines = new ArrayList<>();

    static {
        lines.add(new Line("2호선"));
        lines.add(new Line("3호선"));
        lines.add(new Line("신분당선"));
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static Line getLine(String name) {
        return lines.stream()
                .filter(line -> name.equals(line.getName()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_LINE));
    }

    public static void addLine(String lineName, String upTerminusName, String downTerminusName) {
        if (isExistLine(lineName)) {
            throw new IllegalArgumentException(DUPLICATED_LINE);
        }
        lines.add(new Line(lineName));
    }

    private static boolean isExistLine(String lineName) {
        return lines.stream()
                .anyMatch(line -> lineName.equals(line.getName()));
    }

    public static void deleteLineByName(String name) {
        Line line = getLine(name);

        lines.remove(line);
    }
}
