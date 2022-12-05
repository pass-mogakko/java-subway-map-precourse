package subway.domain;

import java.util.ArrayList;
import java.util.List;
import subway.Constants;



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

    @Override
    public String toString() {
        String result = "";

        result += line.toString() + System.lineSeparator();
        result += Constants.INFO_PREFIX + "---" + System.lineSeparator();
        for (final Station station : stations) {
            result += station.toString() + System.lineSeparator();
        }

        return result;
    }
}
