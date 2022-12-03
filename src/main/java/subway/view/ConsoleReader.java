package subway.view;

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
        String line = readLine();
        // TODO 글자 수, trim, 빈 문자열, 공백 검증
        return line;
    }

    static String readLine() {
        return Console.readLine();
    }
}
