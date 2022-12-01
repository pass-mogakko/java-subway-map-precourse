package subway.domain;

import java.util.List;
import java.util.stream.Collectors;
import subway.constant.ErrorMessage;

public class LineGroup {

    private final List<Line> lines;

    public LineGroup() {
        lines = initDummyData();
    }

    private List<Line> initDummyData() {
        return DummyData.findAllLinesName()
                .stream()
                .map(Line::new)
                .collect(Collectors.toList());
    }

    public Line findLineByName(String name) {
        return lines.stream()
                .filter(line -> line.isSameName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_LINE));
    }
}
