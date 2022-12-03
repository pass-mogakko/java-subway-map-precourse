package subway.view;

import static subway.view.constants.Format.HEADER;
import static subway.view.constants.InputMessage.COMMAND_HEADER;

import subway.view.constants.InputMessage;
import subway.view.constants.MainCommand;
import subway.view.constants.SubCommand;

public class InputView {

    public static MainCommand inputMainCommand() {
        ConsolePrinter.printFormattedLine(HEADER, COMMAND_HEADER.getValue());
        MainCommand mainCommand = ConsoleReader.readMainCommand();
        ConsolePrinter.printBlankLine();
        return mainCommand;
    }

    public static SubCommand inputSubCommand() {
        ConsolePrinter.printFormattedLine(HEADER, COMMAND_HEADER.getValue());
        SubCommand subCommand = ConsoleReader.readSubCommand();
        ConsolePrinter.printBlankLine();
        return subCommand;
    }

    public static String inputName(InputMessage message) {
        ConsolePrinter.printFormattedLine(HEADER, message.getValue());
        String name = ConsoleReader.readName();
        ConsolePrinter.printBlankLine();
        return name;
    }
}
