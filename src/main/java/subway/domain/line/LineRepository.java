package subway.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static subway.domain.util.SetupConstant.*;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();
    
    private LineRepository() {
        save(new Line(LINE_2));
        save(new Line(LINE_3));
        save(new Line(LINE_SINBUNDANG));
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

    public static Line findByName(String name) {
        return lines.stream()
                .filter(line -> line.nameEquals(name))
                .findAny()
                .orElse(null);
    }
}
