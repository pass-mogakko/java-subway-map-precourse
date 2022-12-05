package subway.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();
    
    private LineRepository() {
        save(new Line("2호선"));
        save(new Line("3호선"));
        save(new Line("신분당선"));
    }

    public static List<Line> findAll() {
        return Collections.unmodifiableList(lines);
    }

    public static void save(Line line) {
        lines.add(line);
    }

    public static boolean deleteByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}
