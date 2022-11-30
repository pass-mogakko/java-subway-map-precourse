package subway.domain;

import java.util.List;

public class StationRepository {

    private static Stations stations = new Stations();

    public List<Station> stations() {
        return stations.stations();
    }

    //    private void addStation(String stationName) {
    //        Station station = new Station(stationName);
    //        addStation(station);
    //    }
    //
    //    public void addStation(Station station) {
    //        stations.add(station);
    //
    //    }
    //
    //    public void addStations(List<Station> stations) {
    //        stations.forEach(stations::add);
    //    }
    //
    //
    //    public boolean deleteStation(String name) {
    //        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    //    }
}
