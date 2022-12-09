package subway.domain.section;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import subway.domain.station.Station;

public class Sections {

    private List<Station> sections;

    public Sections(Station upStopStation, Station downStopStation) {
        this.sections = new LinkedList<>();
        sections.add(upStopStation);
        sections.add(downStopStation);
    }

    public void addSection(int index, Station station) {
        sections.add(index, station);
    }

    public List<String> getStationNames() {
        return sections.stream()
                .map(station -> station.getName())
                .collect(Collectors.toList());
    }

    public void deleteSection(Station station) {
        sections.remove(station);
    }
}
