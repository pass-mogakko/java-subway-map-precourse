package subway.service;

import java.util.List;
import java.util.stream.Collectors;
import subway.domain.entity.Station;
import subway.domain.repository.StationRepository;
import subway.dto.StationDTO;

public class StationService {

    private StationService() {
    }

    public static List<StationDTO> getAllStations() {
        return StationRepository.stations()
                .stream()
                .map(station -> new StationDTO(station.getName()))
                .collect(Collectors.toList());
    }

    public static void addStation(StationDTO station) {
        String name = station.getName();
        StationRepository.addStation(new Station(name));
    }

    public static void deleteStation(StationDTO station) {
        String name = station.getName();
        StationRepository.deleteStation(name);
    }
}
