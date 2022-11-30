package subway.domain;

public class Section {

    private final Line line;
    private final Stations stations;

    public Section(Line line, Stations stations) {
        this.line = line;
        this.stations = stations;
    }

    public boolean isSameLineName(String lineName) {
        return line.isSameName(lineName);
    }

    public Line getLine() {
        return line;
    }

    public Stations getStations() {
        return stations;
    }
}
