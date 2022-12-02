package subway.domain.station;

import java.util.List;

public class StationRepository {

    private static StationGroup stationGroup = new StationGroup();

    public static void clear() {
        stationGroup = new StationGroup();
    }

    public static Station findStationByName(String stationName) {
        return stationGroup.findStationByName(stationName);
    }

    public static void addStation(String registerStation) {
        stationGroup.addStationByName(registerStation);
    }

    public static void deleteStation(String deleteStation) {
        stationGroup.deleteStationByName(deleteStation);
    }

    public static List<String> findAllStationNames() {
        return stationGroup.findAllStationNames();
    }

    public static boolean isRegisterStation(String station) {
        return stationGroup.isExistStation(station);
    }
}
