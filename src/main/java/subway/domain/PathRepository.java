package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PathRepository {
    private static final List<Path> paths = new ArrayList<>();

    static {
        paths.add(new Path("2호선", List.of("교대역", "강남역", "역삼역")));
        paths.add(new Path("3호선", List.of("교대역", "남부터미널역", "역삼역", "매봉역")));
        paths.add(new Path("신분당선", List.of("강남역", "양재역", "양재시민의숲역")));
    }

    public static List<Path> paths() {
        return Collections.unmodifiableList(paths);
    }

    public static void addPath(Path path) {
        paths.add(path);
    }

    public static boolean deletePath(String lineName) {
        return paths.removeIf(path -> Objects.equals(path.getLineName(), lineName));
    }

    public static Path findPathOrNullByLineName(String lineName) {
        return paths.stream()
                .filter(path -> Objects.equals(path.getLineName(), lineName))
                .findFirst()
                .orElse(null);
    }

    public static boolean hasStation(String stationName) {
        return paths().stream()
                .anyMatch(path -> path.getStations().contains(stationName));
    }
}
