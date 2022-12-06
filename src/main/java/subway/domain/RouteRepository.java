package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.Constants;



public class RouteRepository {
    private static final String INVALID_ROUTE = Constants.INFO_PREFIX + "존재하지 않는 구간입니다.";
    private static final String DUPLICATE_ROUTE = Constants.INFO_PREFIX + "중복된 노선입니다.";
    private static final String EXIST_STATION = Constants.INFO_PREFIX + "이미 경로에 포함되어있는 역입니다.";
    private static final List<Route> routes = new ArrayList<>();

    static {
        routes.add(new Route("2호선", List.of("교대역", "강남역", "역삼역")));
        routes.add(new Route("3호선", List.of("교대역", "남부터미널역", "양재역", "매봉역")));
        routes.add(new Route("신분당선", List.of("강남역", "양재역", "양재시민의숲역")));
    }

    public static Route getRouteByLineName(String lineName) {
        return routes.stream()
                .filter(route -> lineName.equals(route.getLineName()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_ROUTE));
    }

    public static void addRoute(Route route) {
        if (isExistRoute(route)) {
            throw new IllegalArgumentException(DUPLICATE_ROUTE);
        }

        routes.add(route);
    }

    public static boolean isExistRoute(Route inputRoute) {
        String lineName = inputRoute.getLineName();

        return routes.stream()
                .anyMatch(route -> lineName.equals(route.getLineName()));
    }


    public static List<Route> routes() {
        return Collections.unmodifiableList(routes);
    }

    public static void removeRouteByLineName(String lineName) {
        Route route = getRouteByLineName(lineName);

        routes.remove(route);
    }

    public static void addStation(String lineName, String stationName, int location) {
        Route route = getRouteByLineName(lineName);

        if (route.containsStation(stationName)) {
            throw new IllegalArgumentException(EXIST_STATION);
        }

        route.addStation(stationName, location);
    }
}
