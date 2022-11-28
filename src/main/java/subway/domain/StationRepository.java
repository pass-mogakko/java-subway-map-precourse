package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {

    private static final List<Station> stations = new ArrayList<>();

    public StationRepository() {
        List<String> allStationNameDummy = StationNameDummy.findAllStationNameDummy();
        allStationNameDummy.forEach(StationRepository::addStation);
    }

    private static void addStation(String stationName) {
        Station station = new Station(stationName);
        addStation(station);
    }


    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
