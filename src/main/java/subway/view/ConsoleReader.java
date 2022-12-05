package subway.view;

import static subway.view.constants.ErrorMessage.INPUT_BLANK_NAME;
import static subway.view.constants.ErrorMessage.INPUT_NOT_A_NUMBER_INDEX;

import camp.nextstep.edu.missionutils.Console;
import subway.view.constants.menu.MainCommand;
import subway.view.constants.menu.SubCommand;

public class ConsoleReader {
    private static final String REGEX_NUMBER = "^[1-9][0-9]*$";

    private ConsoleReader() {
    }

    static MainCommand readMainCommand() {
        String line = readLine();
        return MainCommand.find(line);
    }

    static SubCommand readSubCommand() {
        String line = readLine();
        return SubCommand.find(line);
    }

    static String readName() {
        String line = readLine().trim();
        if (line.isBlank()) {
            throw new IllegalArgumentException(INPUT_BLANK_NAME.getValue());
        }
        return line;
    }

    static int readNumber() {
        String line = readLine().trim();
        if (!line.matches(REGEX_NUMBER)) {
            throw new IllegalArgumentException(INPUT_NOT_A_NUMBER_INDEX.getValue());
        }
        return Integer.parseInt(line);
    }

    private static String readLine() {
        return Console.readLine();
    }
}
