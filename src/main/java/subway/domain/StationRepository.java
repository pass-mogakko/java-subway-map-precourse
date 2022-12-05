package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
            throw new IllegalArgumentException("이미 등록된 역 이름입니다.");
        }
    }

    public static void deleteStation(String name) {
        validateNameToDelete(name);
        stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    private static void validateNameToDelete(String name) {
        if (!hasStation(name)) {
            throw new IllegalArgumentException("삭제할 역이 존재하지 않습니다.");
        }
        if (PathRepository.hasStationInPath(name)) {
            throw new IllegalArgumentException("노선에 등록된 역은 삭제할 수 없습니다.");
        }
    }
}
