package subway.domain.line;

public class Line {
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean nameEquals(String input) {
        return name.equals(input);
    }
}
