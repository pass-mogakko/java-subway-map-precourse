package subway.domain.section;

import subway.domain.line.Line;
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
}
