package subway.domain;

import static subway.domain.constants.SubwayRule.LINE_MINIMUM_STATION_COUNT;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Path {
    private final String lineName;
    private final List<String> stations;

    public Path(String lineName, List<String> stations) {
        this.lineName = lineName;
        this.stations = new LinkedList<>(stations);
    }

    public String getLineName() {
        return lineName;
    }

    public List<String> getStations() {
        return Collections.unmodifiableList(stations);
    }

    public void insertStation(int index, String stationName) {
        validateStationName(stationName);
        validateIndex(index);
        stations.add((index - 1), stationName);
    }

    public void deleteStation(String stationName) {
        validateStationsSize(stations.size());
        boolean isDeleted = stations.removeIf(station -> Objects.equals(station, stationName));
        if (!isDeleted) {
            throw new IllegalArgumentException("해당 노선에 포함되지 않은 역입니다.");
        }
    }

    private void validateStationName(String stationName) {
        if (stations.contains(stationName)) {
            throw new IllegalArgumentException("이미 해당 노선에 포함된 역입니다.");
        }
    }

    private void validateIndex(int index) {
        if ((stations.size() + 1) < index) {
            throw new IllegalArgumentException("노선 사이에 빈 구간을 둘 수 없습니다.");
        }
    }

    private void validateStationsSize(int stationsSize) {
        if (stationsSize == LINE_MINIMUM_STATION_COUNT.getValue()) {
            throw new IllegalArgumentException("해당 노선의 역이 2개이므로 더 이상 삭제할 수 없습니다.");
        }
    }
}
