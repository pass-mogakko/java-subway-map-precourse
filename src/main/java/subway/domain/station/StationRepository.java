package subway.domain.station;

public class StationRepository {

    private static StationGroup stationGroup = new StationGroup();

    public static Station findStationByName(String stationName) {
        return stationGroup.findStationByName(stationName);
    }

    //    private void addStation(String stationName) {
    //        Station station = new Station(stationName);
    //        addStation(station);
    //    }
    //
    //    public void addStation(Station station) {
    //        stationGroup.add(station);
    //
    //    }
    //
    //    public void addStations(List<Station> stationGroup) {
    //        stationGroup.forEach(stationGroup::add);
    //    }
    //
    //
    //    public boolean deleteStation(String name) {
    //        return stationGroup.removeIf(station -> Objects.equals(station.getName(), name));
    //    }
}
