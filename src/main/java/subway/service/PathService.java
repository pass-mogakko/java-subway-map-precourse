package subway.service;

import java.util.List;
import java.util.stream.Collectors;
import subway.domain.PathRepository;
import subway.domain.StationRepository;
import subway.dto.PathDTO;

// TODO 검증 로직 클래스 분리
public class PathService {

    public static List<PathDTO> getAllPathsByLine() {
        return PathRepository.paths()
                .stream()
                .map(path -> new PathDTO(path.getLineName(), path.getStations()))
                .collect(Collectors.toList());
    }

    public static void insertStationToPath(String lineName, String stationName, int index) {
        validateStation(stationName);
        PathRepository.insertStationInPath(lineName, stationName, index);
    }

    public static void deleteStationFromPath(String lineName, String stationName) {
        PathRepository.deleteStationInPath(lineName, stationName);
    }

    private static void validateStation(String stationName) {
        if (StationRepository.findStationOrNullByName(stationName) == null) {
            throw new IllegalArgumentException("존재하지 않는 역 이름입니다.");
        }
    }
}
