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

    public void addLine(String lineName) {
        validateLineNameToAdd(lineName);
        LineRepository.addLine(new Line(lineName));
    }

    private void validateLineNameToAdd(String name) {
        if (LineRepository.hasLine(name)) {
            throw new IllegalArgumentException(LINE_EXISTING.getValue());
        }
    }

    public void deleteLine(String lineName) {
        validateLineNameToDelete(lineName);
        LineRepository.deleteLineByName(lineName);
    }

    private void validateLineNameToDelete(String name) {
        if (!LineRepository.hasLine(name)) {
            throw new IllegalArgumentException(LINE_NOT_FOUND.getValue());
        }
    }
}
