package subway.domain;

public class SectionRepository {

    private static final Sections sections = new Sections();

    public static Section findSectionByLineName(String lineName) {
        return sections.findSectionByLineName(lineName);
    }


}
