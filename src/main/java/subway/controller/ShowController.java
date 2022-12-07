package subway.controller;

import subway.domain.Route;
import subway.domain.RouteRepository;
import subway.view.OutputView;

import java.util.List;

public class ShowController implements Controllable {
    @Override
    public void process() {
        List<Route> routes = RouteRepository.routes();

        for (Route route : routes) {
            OutputView.printRoute(route.getLineName(), route.getStationNames());
        }
    }
}
