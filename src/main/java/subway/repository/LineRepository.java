package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import subway.domain.line.Line;
import subway.repository.dto.RouteMapDTO;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static Line findByName(String lineName) {
        return lines.stream()
                .filter(line -> lineName.equals(line.getName()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 노선이 없습니다."));
    }

    public static List<String> readLineNames() {
        return lines.stream()
                .map(line -> line.getName())
                .collect(Collectors.toList());
    }

    public static List<RouteMapDTO> readRouteMaps() {
        return lines.stream()
                .map(line -> new RouteMapDTO(line.getName(), line.getSectionNames()))
                .collect(Collectors.toList());
    }
}
