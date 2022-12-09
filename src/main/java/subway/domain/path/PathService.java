package subway.domain.path;

import static subway.domain.constants.ErrorMessage.DOWN_FINAL_STATION_NOT_FOUND;
import static subway.domain.constants.ErrorMessage.LINE_NOT_FOUND;
import static subway.domain.constants.ErrorMessage.PATH_BY_LINE_NOT_FOUND;
import static subway.domain.constants.ErrorMessage.STATION_NOT_FOUND;
import static subway.domain.constants.ErrorMessage.UP_FINAL_STATION_NOT_FOUND;

import java.util.List;
import java.util.stream.Collectors;
import subway.domain.line.LineRepository;
import subway.domain.station.StationRepository;
import subway.dto.PathDTO;

public class PathService {
    private static PathService instance;

    private PathService() {
    }

    public static PathService getInstance() {
        if (instance == null) {
            instance = new PathService();
        }
        return instance;
    }

    public List<PathDTO> getAllPathsByLine() {
        return PathRepository.paths()
                .stream()
                .map(path -> new PathDTO(path.getLineName(), path.getStationNames()))
                .collect(Collectors.toList());
    }

    public void addPath(String lineName, String upFinalStationName, String downFinalStationName) {
        validateLineName(lineName);
        validateStationNamesToAdd(upFinalStationName, downFinalStationName);
        PathRepository.addPath(new Path(lineName, List.of(upFinalStationName, downFinalStationName)));
    }

    private void validateLineName(String lineName) {
        if (!LineRepository.hasLine(lineName)) {
            throw new IllegalArgumentException(LINE_NOT_FOUND.getValue());
        }
    }

    private void validateStationNamesToAdd(String upFinalStationName, String downFinalStationName) {
        if (!StationRepository.hasStation(upFinalStationName)) {
            throw new IllegalArgumentException(UP_FINAL_STATION_NOT_FOUND.getValue());
        }
        if (!StationRepository.hasStation(downFinalStationName)) {
            throw new IllegalArgumentException(DOWN_FINAL_STATION_NOT_FOUND.getValue());
        }
    }

    public void deletePath(String lineName) {
        validateLineName(lineName);
        PathRepository.deletePath(lineName);
    }

    public void insertStationToPath(String lineName, String stationName, int index) {
        Path path = PathRepository.findPathOrNullByLineName(lineName);
        validateFoundPath(path);
        validateStationName(stationName);
        path.insertStation(index, stationName);
    }

    public void deleteStationFromPath(String lineName, String stationName) {
        Path path = PathRepository.findPathOrNullByLineName(lineName);
        validateFoundPath(path);
        validateStationName(stationName);
        path.deleteStation(stationName);
    }

    private void validateStationName(String stationName) {
        if (!StationRepository.hasStation(stationName)) {
            throw new IllegalArgumentException(STATION_NOT_FOUND.getValue());
        }
    }

    private void validateFoundPath(Path path) {
        if (path == null) {
            throw new IllegalArgumentException(PATH_BY_LINE_NOT_FOUND.getValue());
        }
    }
}
