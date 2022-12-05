package subway.domain.section;

import java.util.ArrayList;
import java.util.List;

public class LineSectionRepository {
    private static final List<LineSection> lineSections = new ArrayList<>();

    private LineSectionRepository() {
    }

    public static void save(LineSection lineSection) {
        lineSections.add(lineSection);
    }
}
