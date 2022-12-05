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

    public String getLineName() {
        return line.getName();
    }

    public boolean lineEquals(Line inputLine) {
        return line.equals(inputLine);
    }

    public void updateSection(Station station, int index) {
        stations.add(index-1, station);
    }

}
