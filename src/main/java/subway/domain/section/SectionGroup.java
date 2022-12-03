package subway.domain.section;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import subway.constant.ErrorMessage;
import subway.domain.DummyData;
import subway.domain.line.Line;
import subway.domain.station.Station;
import subway.domain.station.StationGroup;
import subway.dto.SectionDto;

public class SectionGroup {

    private final List<Section> sections;

    public SectionGroup() {
        sections = initDummyData();
    }

    private List<Section> initDummyData() {
        return Arrays.stream(DummyData.values())
                .map(this::createSection)
                .collect(Collectors.toList());
    }

    private Section createSection(DummyData dummyData) {
        String lineName = dummyData.getLineName();
        Line line = new Line(lineName);
        List<String> stationsName = dummyData.findStationsName();
        StationGroup stationGroup = new StationGroup(stationsName);
        return new Section(line, stationGroup);
    }

    public Section findSectionByLineName(String lineName) {
        return sections.stream()
                .filter(section -> section.isSameLineName(lineName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_SECTION));
    }

    public void registerSection(Line line, Station firstStation, Station lastStation) {
        StationGroup stationGroup = new StationGroup(firstStation, lastStation);
        Section section = new Section(line, stationGroup);
        sections.add(section);
    }

    public void registerSection(String lineName, Station station, int order) {
        Section section = findSectionByLineName(lineName);
        section.addStation(station, order);
    }

    public List<SectionDto> findAllSectionDtos() {
        return sections.stream()
                .map(Section::toDto)
                .collect(Collectors.toList());
    }
}
