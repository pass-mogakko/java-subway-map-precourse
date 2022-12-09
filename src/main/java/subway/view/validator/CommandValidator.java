package subway.view.validator;

import java.util.Arrays;
import java.util.List;
import subway.constants.ExceptionMessage;
import subway.constants.menu.Menu;

public class CommandValidator {

    public static void validateCommand(String command, Menu menu) throws IllegalArgumentException {
        List<String> acceptCommands = Arrays.asList(menu.getAcceptCommand());
        if (!acceptCommands.contains(command)) {
            throw new IllegalArgumentException(ExceptionMessage.CANT_CHOOSE);
        }
    }

}
