package subway.domain.entity;

import static subway.domain.constants.ErrorMessage.PATH_DUPLICATED_STATION;
import static subway.domain.constants.ErrorMessage.PATH_INVALID_INDEX;
import static subway.domain.constants.ErrorMessage.PATH_INVALID_SIZE;
import static subway.domain.constants.ErrorMessage.PATH_INVALID_STATION;
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
            throw new IllegalArgumentException(PATH_INVALID_INDEX.getValue());
        }
    }

    private void validateStationNameToInsert(String stationName) {
        if (stationNames.contains(stationName)) {
            throw new IllegalArgumentException(PATH_DUPLICATED_STATION.getValue());
        }
    }

    public void deleteStation(String stationName) {
        validateStationsSize();
        validateStationNameToDelete(stationName);
        stationNames.removeIf(value -> Objects.equals(value, stationName));
    }

    private void validateStationsSize() {
        if (stationNames.size() == LINE_MINIMUM_STATION_COUNT.getValue()) {
            throw new IllegalArgumentException(PATH_INVALID_SIZE.getValue());
        }
    }

    private void validateStationNameToDelete(String stationName) {
        if (!stationNames.contains(stationName)) {
            throw new IllegalArgumentException(PATH_INVALID_STATION.getValue());
        }
    }
}
