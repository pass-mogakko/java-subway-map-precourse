package subway.service;

import java.util.List;
import java.util.stream.Collectors;
import subway.domain.StationRepository;
import subway.dto.StationDTO;

public class StationService {

    private StationService() { }

    public static List<StationDTO> getAllStations() {
        return StationRepository.stations()
                .stream()
                .map(station -> new StationDTO(station.getName()))
                .collect(Collectors.toList());
    }
}
