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

    public static boolean hasStationInPath(String stationName) {
        return paths().stream()
                .anyMatch(path -> path.getStationNames().contains(stationName));
    }

    public static void addPath(Path path) {
        List<String> stations = path.getStationNames();
        validateLineName(path.getLineName());
        validateNamesToAdd(stations.get(0), stations.get(1));
        paths.add(path);
    }

    private static void validateNamesToAdd(String upFinalStationName, String downFinalStationName) {
        if (!StationRepository.hasStation(upFinalStationName)) {
            throw new IllegalArgumentException("상행 종점역 등록 불가: 존재하지 않는 역 이름입니다.");
        }
        if (!StationRepository.hasStation(downFinalStationName)) {
            throw new IllegalArgumentException("하행 종점역 등록 불가: 존재하지 않는 역 이름입니다.");
        }
    }

    public static void deletePath(String lineName) {
        validateLineName(lineName);
        paths.removeIf(path -> Objects.equals(path.getLineName(), lineName));
    }

    private static void validateLineName(String lineName) {
        if (!LineRepository.hasLine(lineName)) {
            throw new IllegalArgumentException("해당 이름을 가진 노선이 존재하지 않습니다.");
        }
    }

    public static void insertStationToPath(String lineName, String stationName, int index) {
        Path path = findPathOrNullByLineName(lineName);
        validateStationName(stationName);
        path.insertStation(index, stationName);
    }

    private static void validateStationName(String stationName) {
        if (!StationRepository.hasStation(stationName)) {
            throw new IllegalArgumentException("존재하지 않는 역 이름입니다.");
        }
    }

    public static void deleteStationFromPath(String lineName, String stationName) {
        Path path = findPathOrNullByLineName(lineName);
        path.deleteStation(stationName);
    }

    private static Path findPathOrNullByLineName(String lineName) {
        return paths.stream()
                .filter(path -> Objects.equals(path.getLineName(), lineName))
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("해당 이름을 가진 노선 경로 정보가 존재하지 않습니다.");
                });
    }
}
