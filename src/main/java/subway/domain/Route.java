package subway.domain;

import java.util.ArrayList;
import java.util.List;



public class Route {
    private final Line line;
    private final List<Station> stations;

    public Route(final String lineName, final List<String> stationNames) {
        this.line = LineRepository.getLine(lineName);

        this.stations = new ArrayList<>();
        stationNames.stream()
                .forEach(stationName -> {
                    final Station station = StationRepository.getStation(stationName);
                    stations.add(station);
                });
    }
}
