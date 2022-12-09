package subway.view.output;

import java.util.List;
import subway.constants.menu.View;
import subway.repository.dto.RouteMapDTO;

public class RouteMapOutputView implements OutputView {

    public void printRouteMaps(List<RouteMapDTO> routeMaps) {
        routeMaps.stream()
                .forEach(routeMap -> printRouteMap(routeMap));
    }

    public void printRouteMap(RouteMapDTO routeMap) {
        System.out.println(View.INFO + routeMap.getLineName());
        System.out.println(View.INFO + View.LINE);
        routeMap.getStationNames()
                .stream()
                .forEach(name -> System.out.println(View.INFO + name));
        System.out.println();
    }

}
