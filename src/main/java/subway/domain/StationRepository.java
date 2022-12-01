package subway.domain;

public class StationRepository {

    private static Stations stations = new Stations();

    public static Station findStationByName(String stationName) {
        return stations.findStationByName(stationName);
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
