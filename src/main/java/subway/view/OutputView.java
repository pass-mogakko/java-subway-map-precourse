package subway.view;

import static subway.view.constants.Format.HEADER;
import static subway.view.constants.Format.MENU;
import static subway.view.constants.OutputMessage.MAIN_DISPLAY_HEADER;

import java.util.Arrays;
import subway.view.constants.Format;
import subway.view.constants.MainDisplay;

public class OutputView {

    public static void printMain() {
        ConsolePrinter.printFormattedLine(HEADER, MAIN_DISPLAY_HEADER.getValue());
        Arrays.stream(MainDisplay.values())
                        .forEach(value -> ConsolePrinter.printFormattedLine(MENU, value.getCommandKey(), value.getMenu()));
    }

    /**
     * 콘솔 창에 주어진 정보를 출력하는 내부 클래스
     */
    private static class ConsolePrinter {

        static void printLine(Object content) {
            // TODO 출력값 검증
            System.out.println(content);
        }

        static void printFormattedLine(Format format, Object... content) {
            // TODO 출력값 검증
            System.out.printf(format.getValue() + System.lineSeparator(), content);
        }
    }
}
