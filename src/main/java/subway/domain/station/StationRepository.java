package subway.domain.station;

import java.util.*;

import static subway.domain.util.SetupConstant.*;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    private StationRepository() {
        save(new Station(STATION_GYODAE));
        save(new Station(STATION_GANGNAM));
        save(new Station(STATION_YEOKSAM));
        save(new Station(STATION_NAMBU_TERMINAL));
        save(new Station(STATION_YANGJAE));
        save(new Station(STATION_YANGJAE_CITIZENS_FOREST));
        save(new Station(STATION_MAEBONG));
    }
    public static List<Station> findAll() {
        return Collections.unmodifiableList(stations);
    }

    public static void save(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static Station findByName(String name) {
        return stations.stream()
                .filter(station -> station.nameEquals(name))
                .findAny()
                .orElse(null);
    }
}

