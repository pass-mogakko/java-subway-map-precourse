package subway.service;

import java.util.List;
import subway.domain.station.Station;
import subway.repository.StationRepository;

public class StationService {

    public void insert(String stationName) {
        StationRepository.addStation(new Station(stationName));
    }

    public void delete() {

    }

    public List<String> read() {
        return StationRepository.read();
    }

}
