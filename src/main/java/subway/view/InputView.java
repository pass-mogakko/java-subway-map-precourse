package subway.view;

import static subway.view.constants.InputMessage.COMMAND_HEADER;

import subway.view.constants.InputMessage;
import subway.view.constants.menu.MainCommand;
import subway.view.constants.menu.SubCommand;

public class InputView {

    private InputView() {
    }

    public static MainCommand inputMainCommand() {
        ConsolePrinter.printHeader(COMMAND_HEADER.getValue());
        MainCommand mainCommand = ConsoleReader.readMainCommand();
        ConsolePrinter.printBlankLine();
        return mainCommand;
    }

    public static SubCommand inputSubCommand() {
        ConsolePrinter.printHeader(COMMAND_HEADER.getValue());
        SubCommand subCommand = ConsoleReader.readSubCommand();
        ConsolePrinter.printBlankLine();
        return subCommand;
    }

    public static String inputName(InputMessage message) {
        ConsolePrinter.printHeader(message.getValue());
        String name = ConsoleReader.readName();
        ConsolePrinter.printBlankLine();
        return name;
    }

    public static int inputIndex(InputMessage message) {
        ConsolePrinter.printHeader(message.getValue());
        int index = ConsoleReader.readNumber();
        ConsolePrinter.printBlankLine();
        return index;
    }
}
