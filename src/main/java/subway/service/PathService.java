package subway.service;

import java.util.List;
import java.util.stream.Collectors;
import subway.domain.repository.PathRepository;
import subway.dto.PathDTO;

public class PathService {

    private PathService() {
    }

    public static List<PathDTO> getAllPathsByLine() {
        return PathRepository.paths()
                .stream()
                .map(path -> new PathDTO(path.getLineName(), path.getStationNames()))
                .collect(Collectors.toList());
    }

    public static void insertStationToPath(String lineName, String stationName, int index) {
        PathRepository.insertStationToPath(lineName, stationName, index);
    }

    public static void deleteStationFromPath(String lineName, String stationName) {
        PathRepository.deleteStationFromPath(lineName, stationName);
    }
}
