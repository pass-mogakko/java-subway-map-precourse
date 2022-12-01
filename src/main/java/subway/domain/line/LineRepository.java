package subway.domain.line;

public class LineRepository {

    private static final LineGroup lineGroup = new LineGroup();

    public static Line findLineByName(String name) {
        return lineGroup.findLineByName(name);
    }

    //
    //    public boolean deleteLineByName(String name) {
    //        return lineGroup.removeIf(line -> Objects.equals(line.getName(), name));
    //    }
}
