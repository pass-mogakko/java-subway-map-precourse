package subway.domain;

import java.util.List;
import java.util.stream.Collectors;
import subway.constant.ErrorMessage;

public class Stations {

    private final List<Station> stations;

    public Stations(List<String> stationsName) {
        stations = stationsName.stream()
                .map(Station::new)
                .collect(Collectors.toList());
    }

    public Stations() {
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
