package subway.domain.station;

import static subway.domain.constants.ErrorMessage.STATION_EXISTING;
import static subway.domain.constants.ErrorMessage.STATION_IN_LINE;
import static subway.domain.constants.ErrorMessage.STATION_NOT_FOUND;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.domain.path.PathRepository;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    static {
        stations.add(new Station("교대역"));
        stations.add(new Station("강남역"));
        stations.add(new Station("역삼역"));
        stations.add(new Station("남부터미널역"));
        stations.add(new Station("양재역"));
        stations.add(new Station("양재시민의숲역"));
        stations.add(new Station("매봉역"));
    }

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static boolean hasStation(String name) {
        return stations.stream()
                .anyMatch(station -> Objects.equals(station.getName(), name));
    }

    public static void addStation(Station station) {
        validateNameToAdd(station.getName());
        stations.add(station);
    }

    private static void validateNameToAdd(String name) {
        if (hasStation(name)) {
            throw new IllegalArgumentException(STATION_EXISTING.getValue());
        }
    }

    public static void deleteStation(String name) {
        validateNameToDelete(name);
        stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    private static void validateNameToDelete(String name) {
        if (!hasStation(name)) {
            throw new IllegalArgumentException(STATION_NOT_FOUND.getValue());
        }
        if (PathRepository.hasStationInPath(name)) {
            throw new IllegalArgumentException(STATION_IN_LINE.getValue());
        }
    }
}
