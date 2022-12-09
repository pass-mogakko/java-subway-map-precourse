package subway.controller;

import java.util.List;
import subway.dto.PathDTO;
import subway.service.PathService;
import subway.view.OutputView;

public class SubWayLinesController extends Controller {
    private static SubWayLinesController instance;
    private final PathService pathService = PathService.getInstance();

    private SubWayLinesController() {
    }

    public static SubWayLinesController getInstance() {
        if (instance == null) {
            instance = new SubWayLinesController();
        }
        return instance;
    }

    @Override
    public void execute() {
        List<PathDTO> allPathsByLine = pathService.getAllPathsByLine();
        OutputView.printSubwayLines(allPathsByLine);
    }
}
