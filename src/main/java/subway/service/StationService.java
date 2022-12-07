package subway.service;

import java.util.List;
import subway.domain.station.Station;
import subway.repository.StationRepository;

public class StationService {

    public void insert(String stationName) {
        StationRepository.addStation(new Station(stationName));
    }

    public void insertStations(String... stationNames) {
        Arrays.stream(stationNames)
                .forEach(stationName -> insertStation(stationName));
    }

    public void delete(String staitonName) {
        StationRepository.deleteStation(staitonName);
    }

    public List<String> read() {
        return StationRepository.read();
    }

}
