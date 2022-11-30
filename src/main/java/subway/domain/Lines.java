package subway.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lines {

    private final List<Line> lines;

    public Lines() {
        lines = DummyData.findAllLinesName()
                .stream()
                .map(Line::new)
                .collect(Collectors.toList());
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }
}
