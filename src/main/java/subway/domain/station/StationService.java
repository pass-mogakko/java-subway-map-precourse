package subway.domain.station;

import subway.domain.util.ErrorCode;
import subway.domain.util.MessageFactory;
import java.util.List;

class StationService {
    private final static List<String> COMMAND_VALID_RANGE = List.of("1", "2", "3", "B");

    private static final MessageFactory messageFactory = new MessageFactory();

    public void validateCommand(String input) {
        if (!COMMAND_VALID_RANGE.contains(input)) {
            throw new IllegalArgumentException(messageFactory.makeErrorMessage(ErrorCode.INVALID_COMMAND));
        }
    }
}
