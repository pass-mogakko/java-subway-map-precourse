package subway.domain;

import static subway.domain.constants.SubwayRule.LINE_MINIMUM_STATION_COUNT;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Path {
    private final String lineName;
    private final List<String> stationNames;

    public Path(String lineName, List<String> stationNames) {
        this.lineName = lineName;
        this.stationNames = new LinkedList<>(stationNames);
    }

    public String getLineName() {
        return lineName;
    }

    public List<String> getStationNames() {
        return Collections.unmodifiableList(stationNames);
    }

    public void insertStation(int index, String stationName) {
        validateStationNameToInsert(stationName);
        validateIndex(index);
        stationNames.add((index - 1), stationName);
    }

    private void validateIndex(int index) {
        if ((stationNames.size() + 1) < index) {
            throw new IllegalArgumentException("노선 사이에 빈 구간을 둘 수 없습니다.");
        }
    }

    private void validateStationNameToInsert(String stationName) {
        if (stationNames.contains(stationName)) {
            throw new IllegalArgumentException("이미 해당 노선에 포함된 역입니다.");
        }
    }

    public void deleteStation(String stationName) {
        validateStationsSize();
        validateStationNameToDelete(stationName);
        stationNames.removeIf(value -> Objects.equals(value, stationName));
    }

    private void validateStationsSize() {
        if (stationNames.size() == LINE_MINIMUM_STATION_COUNT.getValue()) {
            throw new IllegalArgumentException("해당 노선의 역이 2개이므로 더 이상 삭제할 수 없습니다.");
        }
    }

    private void validateStationNameToDelete(String stationName) {
        if (!stationNames.contains(stationName)) {
            throw new IllegalArgumentException("해당 노선에 포함되지 않은 역입니다.");
        }
    }
}
