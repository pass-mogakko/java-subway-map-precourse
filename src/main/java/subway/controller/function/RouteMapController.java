package subway.controller.function;

import subway.constants.ExceptionMessage;
import subway.controller.ManagementController;
import subway.service.LineService;
import subway.view.output.RouteMapOutputView;

public class RouteMapController implements ManagementController {

    private final LineService lineService = new LineService();
    private final RouteMapOutputView routeMapOutputView = new RouteMapOutputView();

    @Override
    public void execute() {
        read();
    }

    @Override
    public void insert() {
        throw new IllegalArgumentException(ExceptionMessage.CANT_CHOOSE);
    }

    @Override
    public void delete() {
        throw new IllegalArgumentException(ExceptionMessage.CANT_CHOOSE);
    }

    @Override
    public void read() {
        routeMapOutputView.printRouteMaps(lineService.readRouteMaps());
    }
}
