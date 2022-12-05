package subway.service;

import java.util.List;
import java.util.stream.Collectors;
import subway.domain.entity.Line;
import subway.domain.entity.Path;
import subway.domain.repository.LineRepository;
import subway.domain.repository.PathRepository;
import subway.dto.FinalStationsDTO;
import subway.dto.LineDTO;

public class LineService {

    private LineService() {
    }

    public static List<LineDTO> getAllLines() {
        return LineRepository.lines()
                .stream()
                .map(line -> new LineDTO(line.getName()))
                .collect(Collectors.toList());
    }

    public static void addLine(LineDTO lineDTO, FinalStationsDTO finalStations) {
        String lineName = lineDTO.getName();
        String upFinalStationName = finalStations.getUpFinalStationName();
        String downFinalStationName = finalStations.getDownFinalStationName();
        LineRepository.addLine(new Line(lineDTO.getName()));
        PathRepository.addPath(new Path(lineName, List.of(upFinalStationName, downFinalStationName)));
    }

    public static void deleteLine(LineDTO lineDTO) {
        String name = lineDTO.getName();
        LineRepository.deleteLineByName(name);
        PathRepository.deletePath(name);
    }
}
