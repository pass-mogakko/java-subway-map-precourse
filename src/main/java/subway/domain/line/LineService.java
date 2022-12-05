package subway.domain.line;

import subway.domain.util.MessageFactory;
import static subway.domain.util.ErrorCode.*;

public class LineService {
    private static final MessageFactory messageFactory = new MessageFactory();

    public void setUp() {
        LineRepository.setUp();
    }

    public void addLine(String name) {
        validateNewName(name);
        LineRepository.save(new Line(name));
    }

    private void validateNewName(String name) {
        Line line = LineRepository.findByName(name);
        if (line == null) {
            throw new IllegalArgumentException(messageFactory.makeErrorMessage(DUPLICATE_LINE_NAME));
        }
    }
}
