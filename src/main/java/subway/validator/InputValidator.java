package subway.validator;

import subway.Constants;



public class InputValidator {
    private static final int INPUT_LENGTH_LOWER_LIMIT = 2;
    private static final String ERROR_LESS_INPUT_LENGTH = Constants.ERROR_PREFIX + "2글자 이상이여야합니다.";


    public static void validateAddInput(String input) throws IllegalArgumentException {
        if (input.length() < INPUT_LENGTH_LOWER_LIMIT) {
            throw new IllegalArgumentException(ERROR_LESS_INPUT_LENGTH);
        }
    }
}
