package subway.domain.station;

import java.util.List;
import java.util.stream.Collectors;
import subway.constant.ErrorMessage;
import subway.domain.DummyData;

public class StationGroup {

    private List<Station> stations;

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

    public void deleteStationByName(String deleteStation) {
        Station station = findStationByName(deleteStation);
        stations.remove(station);
    }


    public void addStationByName(String registerStation) {
        Station station = new Station(registerStation);
        stations.add(station);
    }

    public boolean isExistStation(String stationName) {
        return stations.stream()
                .anyMatch(station -> station.isSameName(stationName));
    }

    public List<String> findAllStationNames() {
        return stations.stream()
                .map(station -> station.getName())
                .distinct()
                .collect(Collectors.toList());
    }

    public int size() {
        return stations.size();
    }
}
