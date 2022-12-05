package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    static {
        lines.add(new Line("2호선"));
        lines.add(new Line("3호선"));
        lines.add(new Line("신분당선"));
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static boolean hasLine(String name) {
        return lines().stream()
                .anyMatch(line -> Objects.equals(line.getName(), name));
    }

    public static void addLine(Line line) {
        validateNameToAdd(line.getName());
        lines.add(line);
    }

    private static void validateNameToAdd(String name) {
        if (hasLine(name)) {
            throw new IllegalArgumentException("이미 등록된 노선 이름입니다.");
        }
    }

    public static void deleteLineByName(String name) {
        validateNameToDelete(name);
        lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    private static void validateNameToDelete(String name) {
        if (!hasLine(name)) {
            throw new IllegalArgumentException("삭제할 노선이 노선 목록에 존재하지 않습니다.");
        }
    }
}
