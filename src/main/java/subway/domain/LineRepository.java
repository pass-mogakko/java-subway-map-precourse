package subway.domain;

public class LineRepository {

    private static final Lines lines = new Lines();

    public static Line findLineByName(String name) {
        return lines.findLineByName(name);
    }

    //
    //    public boolean deleteLineByName(String name) {
    //        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    //    }
}
