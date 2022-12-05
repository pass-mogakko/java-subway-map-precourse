package subway.domain.section;

import java.util.List;
import subway.domain.line.Line;
import subway.domain.station.Station;
import subway.dto.SectionDto;

public class SectionRepository {

    private static final SectionGroup sections = new SectionGroup();

    public static Section findSectionByLineName(String lineName) {
        return sections.findSectionByLineName(lineName);
    }

    public static void registerSection(Line line, Station firstStation, Station lastStation) {
        sections.registerSection(line, firstStation, lastStation);
    }

    public static void registerSection(String lineName, Station station, int order) {
        sections.registerSection(lineName, station, order);
    }

    public static List<SectionDto> findAllSectionDtos() {
        return sections.findAllSectionDtos();
    }
}
