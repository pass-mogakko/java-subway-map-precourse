package subway.domain;

public class SectionRepository {

    private static final SectionGroup sections = new SectionGroup();

    public static Section findSectionByLineName(String lineName) {
        return sections.findSectionByLineName(lineName);
    }


}
