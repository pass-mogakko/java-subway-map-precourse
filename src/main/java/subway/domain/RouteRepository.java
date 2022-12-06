package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class RouteRepository {
    private static final List<Route> routes = new ArrayList<>();

    static {
        routes.add(new Route("2호선", List.of("교대역", "강남역", "역삼역")));
        routes.add(new Route("3호선", List.of("교대역", "남부터미널역", "양재역", "매봉역")));
        routes.add(new Route("신분당선", List.of("강남역", "양재역", "양재시민의숲역")));
    }

    public static void addRoute(Route route) {
        routes.add(route);
    }

    public static List<Route> routes() {
        return Collections.unmodifiableList(routes);
    }
}
