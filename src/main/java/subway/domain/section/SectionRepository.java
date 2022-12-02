package subway.domain.section;

import java.util.List;
import subway.dto.SectionDto;

public class SectionRepository {

    private static final SectionGroup sections = new SectionGroup();

    public static Section findSectionByLineName(String lineName) {
        return sections.findSectionByLineName(lineName);
    }


    public static void registerSection(String registerLine, String firstStation, String lastStation) {
        sections.registerSection(registerLine, firstStation, lastStation);
    }

    public static int findSectionSizeByLineName(String lineName) {
        Section section = findSectionByLineName(lineName);
        return section.size();
    }

    public static void registerSection(String lineName, String stationName, int order) {
        sections.registerSection(lineName, stationName, order);
    }

    public static List<SectionDto> findAllSectionDtos() {
        return sections.findAllSectionDtos();
    }
}
