package subway.view;

import static subway.view.constants.Format.HEADER;
import static subway.view.constants.Format.MENU;
import static subway.view.constants.OutputMessage.MAIN_DISPLAY_HEADER;

import java.util.Arrays;
import subway.view.constants.MainDisplay;

public class OutputView {

    public static void printMain() {
        ConsolePrinter.printFormattedLine(HEADER, MAIN_DISPLAY_HEADER.getValue());
        Arrays.stream(MainDisplay.values())
                        .forEach(value -> ConsolePrinter.printFormattedLine(MENU, value.getCommandKey(), value.getMenu()));
        ConsolePrinter.printBlankLine();
    }
}
