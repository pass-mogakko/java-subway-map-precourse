package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import subway.constants.ExceptionMessage;
import subway.domain.station.Station;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException(ExceptionMessage.ALREADY_INSERT_STATION);
        }
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static List<String> read() {
        return stations.stream()
                .map(station -> station.getName())
                .collect(Collectors.toList());
    }

    public static Station findByStationName(String stationName) {
        return stations.stream()
                .filter(station -> stationName.equals(station.getName()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("역이 존재하지 않습니다."));
    }
}
