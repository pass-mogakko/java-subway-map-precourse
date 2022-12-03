package subway.view;

import static subway.view.constants.Format.HEADER;
import static subway.view.constants.InputMessage.COMMAND_HEADER;

import subway.view.constants.MainCommand;
import subway.view.constants.SubCommand;

public class InputView {

    public static MainCommand inputMainCommand() {
        ConsolePrinter.printFormattedLine(HEADER, COMMAND_HEADER.getValue());
        return ConsoleReader.readMainCommand();
    }

    public static SubCommand inputSubCommand() {
        ConsolePrinter.printFormattedLine(HEADER, COMMAND_HEADER.getValue());
        return ConsoleReader.readSubCommand();
    }
}
