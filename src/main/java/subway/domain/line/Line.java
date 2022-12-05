package subway.domain.line;

import java.util.List;
import subway.domain.section.Sections;
import subway.domain.station.Station;

public class Line {
    private String name;
    private Sections sections;

    public Line(String name, Station upStopStation, Station downStopStation) {
        this.name = name;
        this.sections = new Sections(upStopStation, downStopStation);
    }

    public String getName() {
        return name;
    }

    public Sections getSections() {
        return this.sections;
    }

    public List<String> getSectionNames() {
        return sections.getStationNames();
    }

    public void addStation(int index, Station station) {
        sections.addSection(index, station);
    }

}
