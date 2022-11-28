package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {

    private static final List<Line> lines = new ArrayList<>();

    public LineRepository() {
        List<String> allLineNameDummy = LineNameDummy.findAllLineNameDummy();
        allLineNameDummy.forEach(LineRepository::addLine);
    }

    private static void addLine(String lineName) {
        Line line = new Line(lineName);
        addLine(line);
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}
