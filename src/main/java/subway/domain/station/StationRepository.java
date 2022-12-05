package subway.domain.station;

import subway.message.ErrorMessage;

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

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static void deleteStation(String name) {
        if (!hasStation(name)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_STATION);
        }
        if (hasStation(name)) {
            deleteStationByName(name);
        }
    }

    public static boolean hasStation(String name) {
        return stations()
                .stream()
                .anyMatch(station -> Objects.equals(station.getName(), name));
    }

    public static Station validateExistStation(String name) {
        if (!hasStation(name)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_STATION);
        }
        return new Station(name);
    }

    public static Station validateDuplication(String name) {
        if (hasStation(name)) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_EXISTING_STATION);
        }
        return new Station(name);
    }

    private static void deleteStationByName(String name) {
        stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
