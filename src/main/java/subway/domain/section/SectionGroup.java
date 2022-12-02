package subway.domain.section;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import subway.constant.ErrorMessage;
import subway.domain.DummyData;
import subway.domain.line.Line;
import subway.domain.station.StationGroup;

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
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_LINE));
    }

    public void registerSection(String registerLine, String firstStation, String lastStation) {
        Line line = new Line(registerLine);
        List<String> stationsName = Arrays.asList(firstStation, lastStation);
        StationGroup stationGroup = new StationGroup(stationsName);
        Section section = new Section(line, stationGroup);
        sections.add(section);
    }
}
