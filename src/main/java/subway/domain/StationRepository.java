package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.Constants;



public class StationRepository {
    private static final String INVALID_STATION = Constants.ERROR_PREFIX + "존재하지 않는 역입니다.";

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

    public static Station getStation(String name) {
        return stations.stream()
                .filter(station -> name.equals(station.getName()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_STATION));
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
