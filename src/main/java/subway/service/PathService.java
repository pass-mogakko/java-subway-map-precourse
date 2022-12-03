package subway.service;

import java.util.List;
import java.util.stream.Collectors;
import subway.domain.PathRepository;
import subway.dto.PathDTO;

public class PathService {

    public static List<PathDTO> getAllPathsByLine() {
        return PathRepository.paths()
                .stream()
                .map(path -> new PathDTO(path.getLineName(), path.getStations()))
                .collect(Collectors.toList());
    }
}
