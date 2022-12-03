package subway.view;

import static subway.view.constants.ErrorMessage.INPUT_BLANK_NAME;

import camp.nextstep.edu.missionutils.Console;
import subway.view.constants.MainCommand;
import subway.view.constants.SubCommand;

public class ConsoleReader {

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

    private static String readLine() {
        return Console.readLine();
    }
}
