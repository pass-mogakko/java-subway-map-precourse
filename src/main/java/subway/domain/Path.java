package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
        stations.add(index, stationName);
    }
}
