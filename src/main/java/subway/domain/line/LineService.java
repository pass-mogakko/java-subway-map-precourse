package subway.domain.line;

import static subway.domain.constants.ErrorMessage.LINE_EXISTING;
import static subway.domain.constants.ErrorMessage.LINE_NOT_FOUND;

import java.util.List;
import java.util.stream.Collectors;
import subway.dto.LineDTO;

public class LineService {
    private static LineService instance;

    private LineService() {
    }

    public static LineService getInstance() {
        if (instance == null) {
            instance = new LineService();
        }
        return instance;
    }

    public List<LineDTO> getAllLines() {
        return LineRepository.lines()
                .stream()
                .map(line -> new LineDTO(line.getName()))
                .collect(Collectors.toList());
    }

    public void addLine(LineDTO lineDTO) {
        String lineName = lineDTO.getName();
        validateLineNameToAdd(lineName);
        LineRepository.addLine(new Line(lineDTO.getName()));
    }

    private void validateLineNameToAdd(String name) {
        if (LineRepository.hasLine(name)) {
            throw new IllegalArgumentException(LINE_EXISTING.getValue());
        }
    }

    public void deleteLine(LineDTO lineDTO) {
        String lineName = lineDTO.getName();
        validateLineNameToDelete(lineName);
        LineRepository.deleteLineByName(lineName);
    }

    private void validateLineNameToDelete(String name) {
        if (!LineRepository.hasLine(name)) {
            throw new IllegalArgumentException(LINE_NOT_FOUND.getValue());
        }
    }
}
