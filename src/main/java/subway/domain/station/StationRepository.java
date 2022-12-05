package subway.domain.station;

import java.util.*;

public class StationRepository {
    private static final List<Station> stations = new LinkedList<>();

    private StationRepository() {
        save(new Station("교대역"));
        save(new Station("강남역"));
        save(new Station("역삼역"));
        save(new Station("남부터미널역"));
        save(new Station("양재역"));
        save(new Station("양재시민의숲역"));
        save(new Station("매봉역"));
    }

    public static List<Station> findAll() {
        return Collections.unmodifiableList(stations);
    }

    public static void save(Station station) {
        stations.add(station);
    }

    static void setUp() {
        save(new Station("교대역"));
        save(new Station("강남역"));
        save(new Station("역삼역"));
        save(new Station("남부터미널역"));
        save(new Station("양재역"));
        save(new Station("양재시민의숲역"));
        save(new Station("매봉역"));
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
