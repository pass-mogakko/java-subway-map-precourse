package subway.domain.subwaylines;

import java.util.List;
import subway.controller.Controller;
import subway.domain.path.PathService;
import subway.dto.PathDTO;
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
    protected void execute() {
        List<PathDTO> allPathsByLine = pathService.getAllPathsByLine();
        OutputView.printSubwayLines(allPathsByLine);
    }
}
