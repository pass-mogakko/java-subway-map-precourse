package subway.service;

import java.util.List;
import java.util.stream.Collectors;
import subway.domain.LineRepository;
import subway.dto.LineDTO;

public class LineService {

    private LineService() { }

    public static List<LineDTO> getAllLines() {
        return LineRepository.lines()
                .stream()
                .map(line -> new LineDTO(line.getName()))
                .collect(Collectors.toList());
    }
}
