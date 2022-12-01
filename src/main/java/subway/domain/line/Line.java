package subway.domain.line;

public class Line {

    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }
}
