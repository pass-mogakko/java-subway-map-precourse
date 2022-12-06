package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import subway.Constants;



public class Route {
    private static final String INVALID_LOCATION = Constants.ERROR_PREFIX + "추가할 수 없는 위치입니다.";
    private static final String EXIST_STATION = Constants.INFO_PREFIX + "이미 경로에 포함되어있는 역입니다.";
    private static final String INVALID_ACCESS = Constants.ERROR_PREFIX + "삭제할 수 없습니다.";
    private static final String INVALID_STATION = Constants.ERROR_PREFIX + "존재하지 않는 역입니다.";
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

    public String getLineName() {
        return line.getName();
    }

    public List<String> getStationNames() {
        return stations.stream()
                .map(Station::toString)
                .collect(Collectors.toList());
    }

    public boolean containsStation(String stationName) {
        return stations.stream()
                .anyMatch(station -> stationName.equals(station.getName()));
    }

    public void addStation(String stationName, int location) {
        if (containsStation(stationName)) {
            throw new IllegalArgumentException(EXIST_STATION);
        }

        if (location < 1 || location > stations.size()) {
            throw new IllegalArgumentException(INVALID_LOCATION);
        }

        Station station = StationRepository.getStation(stationName);

        stations.add(location - 1, station);
    }

    public void removeStation(String stationName) {
        if (stations.size() <= 2) {
            throw new IllegalArgumentException(INVALID_ACCESS);
        }

        if (!containsStation(stationName)) {
            throw new IllegalArgumentException(INVALID_STATION);
        }

        Station station = StationRepository.getStation(stationName);

        stations.remove(station);
    }

    @Override
    public String toString() {
        return "line=" + line +
                ", stations=" + stations;
    }
}
