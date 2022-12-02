package subway.domain.station;

public class StationRepository {

    private static StationGroup stationGroup = new StationGroup();

    public static Station findStationByName(String stationName) {
        return stationGroup.findStationByName(stationName);
    }

    public static void addStation(String registerStation) {
        stationGroup.addStationByName(registerStation);
    }

    public static void deleteStation(String deleteStation) {
        stationGroup.deleteStationByName(deleteStation);
    }
}
