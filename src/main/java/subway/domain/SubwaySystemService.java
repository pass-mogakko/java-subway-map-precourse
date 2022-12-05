package subway.domain;

import subway.domain.util.Validator;

public class SubwaySystemService {
    private static final Validator validator = new Validator();
    private SubwaySystemService() {}

    public static void executeCommand(String command) {
        validator.validateMainInput(command);
    }
}
