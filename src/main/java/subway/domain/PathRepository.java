package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

// TODO 검증 로직 클래스 분리
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

    public static void deletePath(String lineName) {
        boolean isCompleted = paths.removeIf(path -> Objects.equals(path.getLineName(), lineName));
        if (!isCompleted) {
            throw new IllegalArgumentException("해당 이름을 가진 노선이 존재하지 않습니다.");
        }
    }

    public static void insertStationInPath(String lineName, String stationName, int index) {
        Path path = findPathOrNullByLineName(lineName);
        validatePathNullPointed(path);
        path.insertStation(index, stationName);
    }

    public static void deleteStationInPath(String lineName, String stationName) {
        Path path = findPathOrNullByLineName(lineName);
        validatePathNullPointed(path);
        path.deleteStation(stationName);
    }

    public static Path findPathOrNullByLineName(String lineName) {
        return paths.stream()
                .filter(path -> Objects.equals(path.getLineName(), lineName))
                .findFirst()
                .orElse(null);
    }

    private static void validatePathNullPointed(Path path) {
        if (path == null) {
            throw new IllegalArgumentException("해당 이름을 가진 노선이 존재하지 않습니다.");
        }
    }

    // TODO find메소드만 있어도 되므로 삭제
    public static boolean hasStation(String stationName) {
        return paths().stream()
                .anyMatch(path -> path.getStations().contains(stationName));
    }
}
