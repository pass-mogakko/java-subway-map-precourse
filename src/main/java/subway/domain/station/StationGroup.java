package subway.domain.station;

import java.util.List;
import java.util.stream.Collectors;
import subway.constant.ErrorMessage;
import subway.domain.DummyData;

public class StationGroup {

    private final List<Station> stations;

    public StationGroup(List<String> stationsName) {
        stations = stationsName.stream()
                .map(Station::new)
                .collect(Collectors.toList());
    }

    public StationGroup() {
        stations = initDummyData();
    }

    private List<Station> initDummyData() {
        return DummyData.findAllStationsName()
                .stream()
                .map(Station::new)
                .collect(Collectors.toList());
    }

    public Station findStationByName(String stationName) {
        return stations.stream()
                .filter(station -> station.isSameName(stationName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_STATION));
    }

}
