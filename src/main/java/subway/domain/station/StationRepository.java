package subway.domain.station;

import java.util.List;
import subway.constant.ErrorMessage;

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

    public static void validateIsRegisterStation(String station) {
        if (!stationGroup.isExistStation(station)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_STATION);
        }
    }
}
