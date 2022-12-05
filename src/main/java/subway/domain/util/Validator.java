package subway.domain.util;

import java.util.List;

public class Validator {
    private MessageFactory messageFactory = new MessageFactory();

    private final static List<String> MAIN_COMMAND_VALID_RANGE = List.of("1", "2", "3", "4", "Q");

    public void validateMainInput(String input) {
        if (!MAIN_COMMAND_VALID_RANGE.contains(input)) {
            throw new IllegalArgumentException(messageFactory.makeErrorMessage(ErrorCode.INVALID_COMMAND));
        }
    }
}
