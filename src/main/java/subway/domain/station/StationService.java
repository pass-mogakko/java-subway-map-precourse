package subway.domain.station;

import static subway.domain.constants.ErrorMessage.STATION_EXISTING;
import static subway.domain.constants.ErrorMessage.STATION_IN_LINE;
import static subway.domain.constants.ErrorMessage.STATION_NOT_FOUND;

import java.util.List;
import java.util.stream.Collectors;
import subway.domain.path.PathRepository;
import subway.dto.StationDTO;

public class StationService {
    private static StationService instance;

    private StationService() {
    }

    public static StationService getInstance() {
        if (instance == null) {
            instance = new StationService();
        }
        return instance;
    }

    public List<StationDTO> getAllStations() {
        return StationRepository.stations()
                .stream()
                .map(station -> new StationDTO(station.getName()))
                .collect(Collectors.toList());
    }

    public void addStation(StationDTO station) {
        String name = station.getName();
        validateNameToAdd(name);
        StationRepository.addStation(new Station(name));
    }

    private void validateNameToAdd(String name) {
        if (StationRepository.hasStation(name)) {
            throw new IllegalArgumentException(STATION_EXISTING.getValue());
        }
    }

    public void deleteStation(StationDTO station) {
        String name = station.getName();
        validateNameToDelete(name);
        StationRepository.deleteStation(name);
    }

    private void validateNameToDelete(String name) {
        if (!StationRepository.hasStation(name)) {
            throw new IllegalArgumentException(STATION_NOT_FOUND.getValue());
        }
        if (PathRepository.hasStationInPath(name)) {
            throw new IllegalArgumentException(STATION_IN_LINE.getValue());
        }
    }
}
