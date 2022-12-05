package subway.domain.line;

public class LineController {
    private final LineService lineService = new LineService();

    public void setUp() {
        lineService.setUp();
    }

    public void run(){}
}
