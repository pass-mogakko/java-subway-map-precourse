package subway.domain;

public class Section {

    private final Line line;
    private final Stations stations;

    public Section(Line line, Stations stations) {
        this.line = line;
        this.stations = stations;
    }

    public Line getLine() {
        return line;
    }
}
