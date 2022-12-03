package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Path {
    private final String lineName;
    private final List<String> path;

    public Path(String lineName, List<String> path) {
        this.lineName = lineName;
        this.path = new LinkedList<>(path);
    }

    public String getLineName() {
        return lineName;
    }

    public List<String> getPath() {
        return Collections.unmodifiableList(path);
    }
}
