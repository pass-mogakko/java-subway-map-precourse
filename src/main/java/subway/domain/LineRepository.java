package subway.domain;

import java.util.List;

public class LineRepository {

    private static final Lines lines = new Lines();

    public List<Line> lines() {
        return lines.lines();
    }
    //
    //    public boolean deleteLineByName(String name) {
    //        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    //    }
}
