package subway.domain.section;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LineSectionRepository {
    private static final List<LineSection> lineSections = new ArrayList<>();

    private LineSectionRepository() {
    }

    public static void save(LineSection lineSection) {
        lineSections.add(lineSection);
    }

    public static boolean deleteByLineName(String lineName) {
        return lineSections.removeIf(lineSection -> Objects.equals(lineSection.getLineName(), lineName));
    }
}
