package subway.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import subway.constant.ErrorMessage;

public class Sections {

    private final List<Section> sections;

    public Sections() {
        sections = Arrays.stream(DummyData.values())
                .map(this::createSection)
                .collect(Collectors.toList());
    }

    private Section createSection(DummyData dummyData) {
        String lineName = dummyData.getLineName();
        Line line = new Line(lineName);
        List<String> stationsName = dummyData.findStationsName();
        Stations stations = new Stations(stationsName);
        return new Section(line, stations);
    }

    public List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public Section findSectionByLineName(String lineName) {
        return sections.stream()
                .filter(section -> section.isSameLineName(lineName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_LINE));
    }

}
