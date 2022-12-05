package subway.domain.section;

import subway.domain.line.Line;
import subway.domain.station.Station;
import java.util.LinkedList;

public class LineSection {
    private Line line;
    private LinkedList<Station> stations;

    public LineSection(Line line, LinkedList<Station> stations) {
        this.line = line;
        this.stations = stations;
    }
}
