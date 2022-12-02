package subway.domain.line;

import java.util.List;
import java.util.stream.Collectors;
import subway.constant.ErrorMessage;
import subway.domain.DummyData;

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

    public boolean isExistLine(String lineName) {
        return lines.stream()
                .anyMatch(line -> line.isSameName(lineName));
    }

    public void addLineByName(String registerLine) {
        Line line = new Line(registerLine);
        lines.add(line);
    }

    public void deleteLineByName(String lineName) {
        if (!isExistLine(lineName)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_LINE);
        }
        lines.removeIf(line -> line.isSameName(lineName));
    }
}
