package subway.domain.station;

import subway.message.ErrorMessage;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static List<Station> stations;

    public StationRepository(List<Station> stations) {
        StationRepository.stations = init(stations);
    }

    private List<Station> init(List<Station> stations) {
        stations.add(new Station("교대역"));
        stations.add(new Station("강남역"));
        stations.add(new Station("역삼역"));
        stations.add(new Station("남부터미널역"));
        stations.add(new Station("양재역"));
        stations.add(new Station("양재시민의숲역"));
        stations.add(new Station("매봉역"));
        return stations;
    }

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public void addStation(String name) {
        if (hasDuplication(name)) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_EXISTING_STATION);
        }
        if (!hasDuplication(name)) {
            stations.add(new Station(name));
        }
    }

    public void deleteStation(String name) {
        if (!hasDuplication(name)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_STATION);
        }
        stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    private boolean hasDuplication(String name) {
        return stations.stream()
                .anyMatch(station -> Objects.equals(station.getName(), name));
    }
}
