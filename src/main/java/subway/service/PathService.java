package subway.service;

import java.util.List;
import java.util.stream.Collectors;
import subway.domain.Path;
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

    public static void insertPath(String lineName, String stationName, int index) {
        Path path = PathRepository.findPathOrNullByLineName(lineName);
        validate(path, stationName, index);
        path.insertStation((index - 1), stationName);
    }

    private static void validate(Path path, String stationName, int index) {
        validatePath(path);
        List<String> linedStationNames = path.getStations();
        validateStation(linedStationNames, stationName);
        validateIndex(linedStationNames.size(), index);
    }

    private static void validatePath(Path path) {
        if (path == null) {
            throw new IllegalArgumentException("구간을 추가할 노선이 존재하지 않습니다.");
        }
    }

    private static void validateStation(List<String> stationNames, String stationName) {
        if (StationRepository.findStationOrNullByName(stationName) == null) {
            throw new IllegalArgumentException("존재하지 않는 역 이름입니다.");
        }
        if (stationNames.contains(stationName)) {
            throw new IllegalArgumentException("이미 구간에 포함된 역입니다.");
        }
    }

    private static void validateIndex(int stationsSize, int index) {
        if (stationsSize < index) {
            throw new IllegalArgumentException("중간에 빈 구간을 둘 수 없습니다.");
        }
    }
}
