package subway.domain.section;

import subway.domain.line.Line;
import subway.domain.station.Station;
import subway.domain.station.StationGroup;

public class Section {

    private final Line line;
    private final StationGroup stationGroup;

    public Section(Line line, StationGroup stationGroup) {
        this.line = line;
        this.stationGroup = stationGroup;
    }

    public boolean isSameLineName(String lineName) {
        return line.isSameName(lineName);
    }

    public Line getLine() {
        return line;
    }

    public StationGroup getStations() {
        return stationGroup;
    }

    public int size() {
        return stationGroup.size();
    }

    public boolean contains(String stationName) {
        return stationGroup.isExistStation(stationName);
    }

    public void addStation(Station station, int order) {
        stationGroup.addStation(station, order);
    }
}
