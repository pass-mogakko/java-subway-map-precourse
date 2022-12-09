package subway.domain.path;

import static subway.domain.constants.ErrorMessage.DOWN_FINAL_STATION_NOT_FOUND;
import static subway.domain.constants.ErrorMessage.LINE_NOT_FOUND;
import static subway.domain.constants.ErrorMessage.PATH_BY_LINE_NOT_FOUND;
import static subway.domain.constants.ErrorMessage.STATION_NOT_FOUND;
import static subway.domain.constants.ErrorMessage.UP_FINAL_STATION_NOT_FOUND;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.domain.line.LineRepository;
import subway.domain.station.StationRepository;

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
        validateStationNamesToAdd(stations.get(0), stations.get(1));
        paths.add(path);
    }

    private static void validateStationNamesToAdd(String upFinalStationName, String downFinalStationName) {
        if (!StationRepository.hasStation(upFinalStationName)) {
            throw new IllegalArgumentException(UP_FINAL_STATION_NOT_FOUND.getValue());
        }
        if (!StationRepository.hasStation(downFinalStationName)) {
            throw new IllegalArgumentException(DOWN_FINAL_STATION_NOT_FOUND.getValue());
        }
    }

    public static void deletePath(String lineName) {
        validateLineName(lineName);
        paths.removeIf(path -> Objects.equals(path.getLineName(), lineName));
    }

    private static void validateLineName(String lineName) {
        if (!LineRepository.hasLine(lineName)) {
            throw new IllegalArgumentException(LINE_NOT_FOUND.getValue());
        }
    }

    public static void insertStationToPath(String lineName, String stationName, int index) {
        Path path = findPathOrNullByLineName(lineName);
        validateStationName(stationName);
        path.insertStation(index, stationName);
    }

    private static void validateStationName(String stationName) {
        if (!StationRepository.hasStation(stationName)) {
            throw new IllegalArgumentException(STATION_NOT_FOUND.getValue());
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
                    throw new IllegalArgumentException(PATH_BY_LINE_NOT_FOUND.getValue());
                });
    }
}
