package subway.controller.function;

import subway.controller.ManagementController;
import subway.service.LineService;
import subway.view.output.RouteMapOutputView;

public class RouteMapController implements ManagementController {

    private final LineService lineService = new LineService();
    private final RouteMapOutputView routeMapOutputView = new RouteMapOutputView();

    @Override
    public void execute() {
        System.out.println("푸하하");
        routeMapOutputView.printRouteMaps(lineService.readRouteMaps());
    }
}
