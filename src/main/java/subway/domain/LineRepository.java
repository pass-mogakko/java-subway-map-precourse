package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.Constants;



public class LineRepository {
    private static final String INVALID_LINE = Constants.ERROR_PREFIX + "존재하지 않는 노선입니다.";
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

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}
